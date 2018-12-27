package com.lswq.disruptor.compare;

public class Data {

    private long value;


    /**
     * 添加默认的构造方法
     */
    public Data() {

    }

    public Data(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
