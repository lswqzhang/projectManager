package com.lswq.disruptor.heigh;

import com.lmax.disruptor.EventHandler;

public class TradeHandler4 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 4 : SET PRICE");
        Thread.sleep(1000);
        event.setPrice(17.0);
    }
}
