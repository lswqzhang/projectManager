package com.lswq;

import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;

public class TestUnit {
    
    @Test
    public void testSimple() {
        System.err.println(StringSerializer.class.getCanonicalName());
    }
    
}
