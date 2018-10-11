package com.lswq.wang.firstpart.chapter2;

/**
 * 税务信息计算策略
 */
@FunctionalInterface
public interface TaxCalculatorStrategy {
    double calculate(double salary, double bonus);
}
