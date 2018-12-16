package com.lswq.kafak.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 自定义分区策略
 * 
 * @author zhangsw 
 */
public class BananaPartitioner implements Partitioner {
    
    private static final Logger logger = LoggerFactory.getLogger(BananaPartitioner.class);

    @Override
    public void configure(Map<String, ?> configs) {

    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        Integer count = cluster.partitionCountForTopic(topic);

        
        logger.info("the topic total partition is {}", count);
        
        logger.info("the message key is {}", key);
        
        return 0;
        
    }

    @Override
    public void close() {

    }


}
