package com.lswq.kafak.serializer;

import com.lswq.entry.Customer;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;


public class CustomerSerializer implements Serializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // 不做任务配置
    }

    @Override
    public byte[] serialize(String topic, Customer data) {

        byte[] serializerName;
        int stringSize;

        if (null == data) {
            return null;
        } else {
            try {
                if (data.getCustomerName() != null) {
                    serializerName = data.getCustomerName().getBytes("UTF-8");
                } else {
                    serializerName = new byte[0];
                }
                stringSize = serializerName.length;
                ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + stringSize);
                buffer.putInt(data.getCustomerId());
                buffer.putInt(stringSize);
                buffer.put(serializerName);
                return buffer.array();
            } catch (UnsupportedEncodingException e) {
                throw new SerializationException("", e);
            }
        }
    }

    @Override
    public void close() {
        // 不需要关闭任务东西
    }
}
