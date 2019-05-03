package com.lswq.sha256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA_256 {

    private static String[] binaryArray =
            {"0000", "0001", "0010", "0011",
                    "0100", "0101", "0110", "0111",
                    "1000", "1001", "1010", "1011",
                    "1100", "1101", "1110", "1111"};

    public static void main(String[] args) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        String str = "22";

        digest.update(str.getBytes(StandardCharsets.UTF_8));

        System.err.println(bytes2BinaryStr(digest.digest()));

    }

    /**
     * 　　* 将byte转为16进制
     * 　　* @param bytes
     * 　　* @return
     */


    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    /**
     * @param bArray
     * @return 转换为二进制字符串
     */
    public static String bytes2BinaryStr(byte[] bArray) {

        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {
            //高四位  
            pos = (b & 0xF0) >> 4;
            outStr += binaryArray[pos];
            //低四位  
            pos = b & 0x0F;
            outStr += binaryArray[pos];
        }
        return outStr;

    }
}
