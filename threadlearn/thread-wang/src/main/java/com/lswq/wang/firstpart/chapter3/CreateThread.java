package com.lswq.wang.firstpart.chapter3;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程
 */
public class CreateThread {
    public static void main(String[] args) {
        // 如果不传入ThreadGroup时，则子线程与start在同一个ThreadGroup中
        new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.err.println(threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.err::println);
    }
}
