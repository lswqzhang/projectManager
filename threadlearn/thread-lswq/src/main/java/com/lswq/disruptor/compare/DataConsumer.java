package com.lswq.disruptor.compare;


import com.lmax.disruptor.EventHandler;

/**
 * 消费者
 */
public class DataConsumer implements EventHandler<Data> {

    private long start;
    private int i;

    public DataConsumer() {
        this.start = System.currentTimeMillis();
    }

    @Override
    public void onEvent(Data event, long sequence, boolean endOfBatch) throws Exception {
        i++;
        if (i == 1000000) {
            long end = System.currentTimeMillis();
            System.err.println("disruptor used time is " + (end - start) / 100.00 + "s");
        }
    }
}
