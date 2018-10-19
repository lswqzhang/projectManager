package com.lswq.jcu.aqs.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程
 *
 * @author zhangshaowei
 */
public class RunnableTest implements Runnable {

    private final Lock lock = new ReentrantLock();

    private final List<String> list = new ArrayList<>();

    private static Integer i = 0;

    public RunnableTest(Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (i < 6) {
            lock.lock();
            lock.lock();
            lock.lock();
            try {
                i++;
                list.add(String.valueOf(i));
                System.out.println("Adding element by thread " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
                lock.unlock();
                lock.unlock();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
