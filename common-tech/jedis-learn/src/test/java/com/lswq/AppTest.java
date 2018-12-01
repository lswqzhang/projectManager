package com.lswq;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import redis.clients.jedis.Jedis;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {


    // redis host
    private static final String HOST = "192.168.15.195";
    // redis port
    private static final int PORT = 16379;


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
    public void testApp() {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.select(4);
        jedis.set("lswq:zhang", "hello");
        System.err.println(jedis.get("lswq:zhang"));
    }
}
