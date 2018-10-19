package com.lswq.jcu.aqs;

import com.lswq.jcu.aqs.entity.RunnableTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeArrayList<E> {
    private final Lock lock = new ReentrantLock();

    private final List<E> list = new ArrayList<>();

    private static int i = 0;

    public void set(E o) {
        lock.lock();
        lock.lock();
        try {
            i++;
            list.add(o);
            System.out.println("Adding element by thread " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final ThreadSafeArrayList<String> lockExample = new ThreadSafeArrayList<>();

        RunnableTest lockingThread = new RunnableTest(lockExample, i);

        Thread t2 = new Thread(lockingThread, "lockingThread");
        t2.start();
    }
}

