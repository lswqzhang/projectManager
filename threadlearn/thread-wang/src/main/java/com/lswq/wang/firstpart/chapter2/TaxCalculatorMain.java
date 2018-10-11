package com.lswq.wang.firstpart.chapter2;

/**
 * 通过策略模式计算税务信息
 * 打折信息也可以使用简略进行计算
 * java中的Runnable可以看作一个计算单元，而Thread和Runnable就是一个策略模式的实现
 * 
 * @author zhangsw 
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
        
        TaxCalculatorStrategy strategy = new TaxCalculatorStrategy() {
            private static final double SALARY_RATE = 0.1;
            private static final double BONUS_RATE = 0.15;
            @Override
            public double calculate(double salary, double bonus) {
                return salary * SALARY_RATE + bonus * BONUS_RATE;
            }
        };
        
        // 常规java编程
        TaxCalculator calculator1 = new TaxCalculator(10000, 2000, strategy);
        System.err.println(calculator1.calculate());
        
        // lambda编程方式
        TaxCalculator calculator2 = new TaxCalculator(10000, 2000, (s, b) -> s * 0.1 + b * 0.15);
        System.err.println(calculator2.calculate());
    }
}
