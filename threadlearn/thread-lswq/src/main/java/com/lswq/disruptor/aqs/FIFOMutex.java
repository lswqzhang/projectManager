package com.lswq.disruptor.aqs;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != current ||
                !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) // ignore interrupts while waiting
            {
                wasInterrupted = true;
            }
        }

        waiters.remove();
        if (wasInterrupted)          // reassert interrupt status on exit
        {
            current.interrupt();
        }
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }


    public static void main(String[] args) throws Exception {

        lockSupport();

    }


    public static void lockSupport() throws Exception {

        Thread a = new Thread(new Runnable() {
            int sum = 0;

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }

                LockSupport.park();
                System.err.println("the sum is " + sum);
            }


        });

        a.start();

        TimeUnit.SECONDS.sleep(2);
        
        LockSupport.unpark(a);
    }


    public static void objectLock() throws Exception {
        Object lock = new Object();

        Thread a = new Thread(new Runnable() {
            int sum = 0;

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }

                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.err.println("the sum is " + sum);
            }


        });

        a.start();

        TimeUnit.SECONDS.sleep(2);

        synchronized (lock) {
            lock.notify();
        }
    }
}
