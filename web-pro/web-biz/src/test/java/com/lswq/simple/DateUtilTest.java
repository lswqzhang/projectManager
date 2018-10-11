package com.lswq.simple;

import com.lswq.service.util.DateUtil;
import org.junit.Test;

import java.util.Date;

public class DateUtilTest {
    
    @Test
    public void parseDateTest() {
        System.err.println(DateUtil.formatDate(new Date(), DateUtil.YMDHMS_));
    }
    
}
