package com.lswq.disruptor.heigh;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.CountDownLatch;

public class TradePublisher implements Runnable {

    private CountDownLatch countDownLatch;
    private Disruptor<Trade> disruptor;

    public TradePublisher(CountDownLatch countDownLatch, Disruptor<Trade> disruptor) {
        this.countDownLatch = countDownLatch;
        this.disruptor = disruptor;
    }

    @Override
    public void run() {


        EventTranslator<Trade> eventTranslator = new EventTranslator() {
            @Override
            public void translateTo(Object event, long sequence) {

            }
        };

        disruptor.publishEvent(eventTranslator);
    }
}
