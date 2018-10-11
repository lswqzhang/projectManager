package com.lswq.wang.firstpart.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * 线程学习
 * 
 * @author zhangsw 
 */
public class TryConcurrency {


    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            TimeUnit.MINUTES.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
