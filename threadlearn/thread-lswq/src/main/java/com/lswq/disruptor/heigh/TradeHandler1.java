package com.lswq.disruptor.heigh;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class TradeHandler1 implements EventHandler<Trade>, WorkHandler<Trade> {
    //EventHandler
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }

    //WorkHandler
    @Override
    public void onEvent(Trade event) throws Exception {
        System.err.println("handler 1 : SET NAME");
        Thread.sleep(1000);
        event.setName("H1");
    }
}
