package com.lswq.trie;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
