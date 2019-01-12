package com.lswq.jcu.aqs;

public class FinallyTest {
    public static void main(String[] args) {

        FinallyTest finallyTest = new FinallyTest();

        System.err.println("the finally has not return value is " + finallyTest.test());
        System.out.println("the finally has return is " + finallyTest.testFinallyReturn());
        System.out.println("has exception return is " + finallyTest.testExceptionReturn());

    }

    static int test() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            ++x;
            System.err.println("finally print is " + x);
        }
    }

    static int testFinallyReturn() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            ++x;
            System.out.println("has finally print is " + x);
            return x;
        }
    }

    static int testExceptionReturn() {
        int x = 1;
        try {
            x++;
            int i = x / 0;
            return x;
        } catch (Exception e) {
            x++;
            return x;
        } finally {
            ++x;
            System.out.println("has exception print is " + x);
        }
    }
}
