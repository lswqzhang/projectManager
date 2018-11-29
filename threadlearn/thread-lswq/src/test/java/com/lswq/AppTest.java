package com.lswq;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 8, 100L, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(10),
                (r, e) -> {

                });
        for (int i = 0; i < 19; i++) {
            executor.submit(() -> {
                try {
                    TimeUnit.HOURS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(10L);

        System.err.println(executor.toString());

        Thread.currentThread().join();
    }
}
