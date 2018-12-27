package com.lswq.disruptor.heigh;

import java.util.concurrent.atomic.AtomicInteger;

public class Trade {
    private String id;
    private String name;
    private double price;
    private AtomicInteger count = new AtomicInteger(0);

    public Trade() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trade{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
