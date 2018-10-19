package com.lswq.jcu.aqs;

import com.lswq.jcu.aqs.entity.RunnableTest;

public class ThreadSafeArrayList {


    public static void main(String[] args) throws InterruptedException {
        final RunnableTest<String> lockExample = new RunnableTest(0);
        Thread t2 = new Thread(lockExample, "lockingThread");
        t2.start();
        t2.join();
    }
}

