package com.lswq;

import com.lswq.kafak.partitioner.BananaPartitioner;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    private static final String TOPIC = "lswq_test_topic";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

        logger.debug("测试");

        Properties kafkaProperties = new Properties();
        kafkaProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.15.195:9092,192.168.15.195:9093");
        kafkaProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());
        kafkaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getCanonicalName());
        kafkaProperties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, BananaPartitioner.class.getCanonicalName());
        kafkaProperties.put(ProducerConfig.ACKS_CONFIG, "1");


        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProperties);

        List<PartitionInfo> partitions = producer.partitionsFor(TOPIC);

        for (PartitionInfo info : partitions) {
            logger.info("current partition number is {}, the main partition node is {}", info.partition(), info.leader().port());
            Node[] replicas = info.replicas();
            for (int i = 0; i < replicas.length; i++) {
                Node n = replicas[i];
                logger.debug("the partitions node is {}", n);
            }
        }

        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, "Precision products", "France");

        // 无返回
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  同步
        try {
            RecordMetadata metadata = (RecordMetadata) producer.send(record).get();
            System.err.println(metadata);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //  异步
        producer.send(record, new DemoProducerCallback());

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private class DemoProducerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            //  返回一个非空的异常，进行异常处理 
            if (null != exception) {
                logger.error("数据发送失败", exception);
            } else {
                logger.info("异步发送数据发送成功, send topic is {}, offset is {}, the partition is {}"
                        , metadata.topic()
                        , metadata.offset()
                        , metadata.partition());
            }
        }
    }


}
