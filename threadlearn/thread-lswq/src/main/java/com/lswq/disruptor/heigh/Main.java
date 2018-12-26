package com.lswq.disruptor.heigh;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) throws Exception {

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        Disruptor<Trade> disruptor = new Disruptor<>(
                new TradeFactory(),
                1024,
                threadFactory,
                ProducerType.SINGLE,
                new BusySpinWaitStrategy()
        );


        TradeHandler1 h1 = new TradeHandler1();
        TradeHandler2 h2 = new TradeHandler2();
        TradeHandler3 h3 = new TradeHandler3();
        TradeHandler4 h4 = new TradeHandler4();
        TradeHandler5 h5 = new TradeHandler5();
        disruptor.handleEventsWith(h1, h4);
        disruptor.after(h1).handleEventsWith(h2);
        disruptor.after(h4).handleEventsWith(h5);
        disruptor.after(h2, h5).handleEventsWith(h3);
        
        
        disruptor.start();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        
        CountDownLatch countDownLatch = new CountDownLatch(1);

        TradePublisher publisher = new TradePublisher(countDownLatch, disruptor);
        executorService.submit(publisher);


        countDownLatch.await();
        disruptor.shutdown();
        executorService.shutdown();
    }

}
