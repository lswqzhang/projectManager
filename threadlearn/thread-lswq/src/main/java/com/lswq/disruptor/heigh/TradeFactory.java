package com.lswq.disruptor.heigh;

import com.lmax.disruptor.EventFactory;

/**
 * 一个消费者创建事件
 * 
 * @author zhangsw 
 */
public class TradeFactory implements EventFactory<Trade> {

    @Override
    public Trade newInstance() {
        return new Trade();
    }
}
