package com.lswq.disruptor.heigh;

import com.lmax.disruptor.EventHandler;

import java.util.UUID;

public class TradeHandler2 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 2 : SET ID");
        Thread.sleep(2000);
        event.setId(UUID.randomUUID().toString());
    }
}
