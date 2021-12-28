package com.itnkc.register.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Description：
 * @Author: nkc
 * @Date: 2021/12/28 11:21
 */
public class MD5Utils {
    /**
     * @param text 明文
     * @Description: MD5加密
     */
    public static String md5(String text) {
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(text);
        return md5str;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5  密文
     */
    public static boolean verify(String text, String md5) {
        String md5str = md5(text);
        if (md5str.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }


}
