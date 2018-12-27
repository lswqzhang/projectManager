package com.lswq.disruptor.compare;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * block queue test
 */
public class ArrayListBlockQueueTest {


    public static void main(String[] args) {

        BlockingQueue<Data> queue = new ArrayBlockingQueue<>(100000000);

        long start = System.currentTimeMillis();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                Data data = new Data(i);
                try {
                    queue.put(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.err.println("block queue used time is " + ((System.currentTimeMillis()) - start) / 100.00 + "s");
        }).start();
        
        
    }

}
