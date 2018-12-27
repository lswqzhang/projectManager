package com.lswq.disruptor.compare;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

public class DisruptorSingle4Test {


    public static void main(String[] args) {

        int ringBuffer = 65536;

        Disruptor<Data> disruptor = new Disruptor<>(
                () -> new Data(),
                ringBuffer,
                Executors.privilegedThreadFactory(),
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );

        disruptor.handleEventsWith(new DataConsumer());

        disruptor.start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                int finalI = i;
                // 快速创建生产者信息
                disruptor.publishEvent(new EventTranslator<Data>() {
                    @Override
                    public void translateTo(Data event, long sequence) {
                        event.setValue(finalI);
                    }
                });
            }
        }).start();


    }


}
