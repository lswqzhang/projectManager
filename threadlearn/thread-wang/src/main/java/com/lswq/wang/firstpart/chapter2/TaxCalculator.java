package com.lswq.wang.firstpart.chapter2;

/**
 * 税务收取逻辑控制
 * 
 * @author zhangsw 
 */
public class TaxCalculator {
    
    private final double salary;
    private final double bonus;
    private TaxCalculatorStrategy strategy;

    public TaxCalculator(double salary, double bonus, TaxCalculatorStrategy strategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.strategy = strategy;
    }
    
    private double calcTax() {
        return this.strategy.calculate(salary, bonus);
    }
    
    
    public double calculate() {
        return this.calcTax();
    }
    

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}
