package com.lswq.bitmap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class BitMapSort {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(BitMapSort.class);

    public static Integer[] sort(Integer nums, Integer array[]) {

        byte[] loop = new byte[nums];

        Integer[] sort = new Integer[array.length];

        logger.info("--------------开始位向量排序--------------");
        Date begin = new Date();
        //将数据插入位图
        for (int j = 0; j < array.length; j++) {
            Integer integer = array[j];
            loop[integer] = 1;
        }
        //输出排序
        for (int j = 0, k = 0; k < nums; k++) {
            if (loop[k] == 1) {
                sort[j++] = k;
            }
        }
        Date end = new Date();
        logger.info("位向量排序结束");
        logger.info("位向量排序耗时: {} 分钟 {} 秒", end.getMinutes() - begin.getMinutes(), end.getSeconds() - begin.getSeconds());
        return sort;
    }
}
