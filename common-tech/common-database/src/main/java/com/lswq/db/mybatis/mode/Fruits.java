package com.lswq.db.mybatis.mode;

import java.io.Serializable;
import java.math.BigDecimal;

public class Fruits implements Serializable {
    // 属性名和数据库表的字段对应
    private int id;
    private String type;// 用户姓名
    private String variety;// 性别
    private BigDecimal price;// 生日

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(",\"type\":\"").append(type).append('\"');
        sb.append(",\"variety\":\"").append(variety).append('\"');
        sb.append(",\"price\":").append(price);
        sb.append('}');
        return sb.toString();
    }
}
