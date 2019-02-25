package com.lswq.jcu.aqs.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 *
 * @author zhangshaowei
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        ThreadPoolExecutorTest test = new ThreadPoolExecutorTest();
        test.test();
    }

    public ThreadPoolExecutor test() {
        ThreadPoolExecutorSupport executor = new ThreadPoolExecutorSupport(
                11,
                100,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }


}
