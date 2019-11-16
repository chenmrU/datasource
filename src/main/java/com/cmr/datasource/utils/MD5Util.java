package com.cmr.datasource.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author chenmengrui
 * @Description: MD5加密工具类
 * @date 2019/11/16 14:13
 */
public class MD5Util {

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 5;

    public static String encrypt(String password, String salt) {
        return new SimpleHash(ALGORITH_NAME, password, salt, HASH_ITERATIONS).toString();
    }

}
