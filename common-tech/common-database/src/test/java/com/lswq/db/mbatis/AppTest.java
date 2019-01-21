package com.lswq.db.mbatis;

import com.lswq.db.mybatis.App;
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
        userMapperInterfaceQueryTest();
        userInterfaceQueryTest();
        userMyBatisSelectTest();
    }


    public void userMapperInterfaceQueryTest() {
        App app = new App();
        app.userInterfaceMapperQuery();
    }

    public void userInterfaceQueryTest() {
        App app = new App();
        app.userInterfaceQuery();
    }

    public void userMyBatisSelectTest() {
        App app = new App();
        app.userMyBatisSelect();
    }
}
