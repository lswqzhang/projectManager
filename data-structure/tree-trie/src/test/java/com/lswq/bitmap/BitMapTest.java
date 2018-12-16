package com.lswq.bitmap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

/**
 * 位图的使用
 *
 * @author zhangshaowei
 */
public class BitMapTest {

    /**
     * Logger for this class
     */
    private static final Log logger = LogFactory.getLog(BitMapTest.class);

    private static int NUMS = 1000;

//    public static void main(String[] args) {
//        logger.info("--------------生存" + NUMS + "以内的稠密数组--------------");
//        Integer array[] = InitArray.getArray(NUMS);
//        logger.info("--------------生成完毕--------------");
//        Integer[] sort = BitMapSort.sort(NUMS, array);
//        for (Integer a : sort) {
//            System.err.println(a.intValue());
//        }
//    }


    private static final int CAPACITY = 1000000000;//数据容量

    // 定义一个byte数组缓存所有的数据
    private byte[] dataBytes = new byte[1 << 29];

    public static void main(String[] args) {
        BitMapTest ms = new BitMapTest();

        byte[] bytes = null;

        Random random = new Random();
        for (int i = 0; i < CAPACITY; i++) {
            int num = random.nextInt();
            System.out.println("读取了第 " + (i + 1) + "\t个数: " + num);
            bytes = ms.splitBigData(num);
        }
        System.out.println("");
        ms.output(bytes);
    }


    /**
     * 读取数据，并将对应数数据的 到对应的bit中，并返回byte数组
     *
     * @param num 读取的数据
     * @return byte数组  dataBytes
     */
    private byte[] splitBigData(int num) {

        long bitIndex = num + (1l << 31);         //获取num数据对应bit数组（虚拟）的索引
        int index = (int) (bitIndex / 8);         //bit数组（虚拟）在byte数组中的索引
        int innerIndex = (int) (bitIndex % 8);    //bitIndex 在byte[]数组索引index 中的具体位置

        System.out.println("byte[" + index + "] 中的索引：" + innerIndex);

        dataBytes[index] = (byte) (dataBytes[index] | (1 << innerIndex));
        return dataBytes;
    }

    /**
     * 输出数组中的数据
     *
     * @param bytes byte数组
     */
    private void output(byte[] bytes) {
        int count = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(((bytes[i]) & (1 << j)) == 0)) {
                    count++;
                    int number = (int) ((((long) i * 8 + j) - (1l << 31)));
                    System.out.println("取出的第  " + count + "\t个数: " + number);
                }
            }
        }
    }

}
