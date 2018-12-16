package com.lswq.bitmap;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 数据生成
 *
 * @author zhangshaowei
 */
public class InitArray {
    public static Integer[] getArray(int nums) {
        int count = 0;
        Random random = new Random(new Date().getTime());
        Set<Integer> set = new HashSet<>();
        for (; count < nums; count++) {
            set.add((int) (random.nextFloat() * nums));
        }
        return set.toArray(new Integer[]{});
    }
}
