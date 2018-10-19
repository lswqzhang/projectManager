package com.lswq.jcu.aqs.entity;

import com.lswq.jcu.aqs.ThreadSafeArrayList;

/**
 * 线程
 *
 * @author zhangshaowei
 */
public class RunnableTest implements Runnable {

    final ThreadSafeArrayList<String> lockExample;

    private int i;

    public RunnableTest(ThreadSafeArrayList<String> lockExample, int i) {
        this.i = i;
        this.lockExample = lockExample;
    }

    @Override
    public void run() {
        while (i < 6) {
            lockExample.set(String.valueOf(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
