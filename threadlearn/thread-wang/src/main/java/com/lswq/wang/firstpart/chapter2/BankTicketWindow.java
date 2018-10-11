package com.lswq.wang.firstpart.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

public class BankTicketWindow implements Runnable{
    
    private static final int MAX = 500;
    private AtomicInteger index = new AtomicInteger(1);
    
    @Override
    public void run() {
        while (index.get() < MAX) {
            System.err.println(Thread.currentThread().getName() + "开始叫号:" + index.getAndIncrement());
        }
    }
}
