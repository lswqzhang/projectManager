package com.lswq.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志
 */
public class LogTest {
    public static final Logger logger= LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        
        
        int a = 10;
        
        if ((a & 1) == 0)
            System.err.println("偶");
        a = a + 1;
        if ((a & 1) == 1)
            System.err.println("奇");
        
        logger.trace("trace");
        logger.debug("debug");
        logger.warn("warn");
        logger.info("info");
        logger.error("error");
    }
}
