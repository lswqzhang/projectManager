package com.lswq.trie;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.BitSet;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
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


        BitSet bitSet = new BitSet();
        bitSet.set(1);


        System.err.println(bitSet.get(0));


        Integer a = 64;

        Integer integer = Integer.valueOf("00100000", 2);
        System.err.println(integer);

        System.err.println(Integer.toBinaryString(a));


        System.err.println("long is " + Long.toBinaryString(0xFFFFFFFFEFFFFFFFL));

        if ((a & integer) == integer) {
            System.err.println("偶数");
        }



        
        int x1 = 3, x2 = 4;

        x1 = x1 ^ x2;
        x2 = x1 ^ x2;
        x1 = x1 ^ x2;

        System.err.println("x1 = " + x1 + ", x2 = " + x2);

        int x = 0x7fffffff;
        System.err.println("test   " + Integer.toBinaryString(x));
        System.err.println("int test " + x + ",the int max is " + Integer.MAX_VALUE);
        

        int x1_ = ~x1 + 1;

        System.err.println("x1的负数为： " + x1_);

        int x3 = -10;

        int x3_ = ~x3 + 1;
        System.err.println("x3的负数为： " + x3_);


        // 年、月、日、时、分、秒
        int[][][][][][] time = new int[100][12][31][24][60][60];
        
        
        Tries tree = new Tries();
        String[] strs = {
                "banana",
                "band",
                "bee",
                "absolute",
                "acm",
        };
        String[] prefix = {
                "ba",
                "b",
                "band",
                "abc",
        };
        for (String str : strs) {
            tree.insert(str);
        }
        System.out.println(tree.has("abc"));
        tree.preTraverse(tree.getRoot());
        System.out.println();
        tree.printAllWords();
        for (String pre : prefix) {
            int num = tree.countPrefix(pre);
            System.out.println(pre + " " + num);
        }
    }
}
