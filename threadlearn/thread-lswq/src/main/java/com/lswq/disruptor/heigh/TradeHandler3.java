package com.lswq.disruptor.heigh;

import com.lmax.disruptor.EventHandler;

public class TradeHandler3 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println(event);
    }
}
