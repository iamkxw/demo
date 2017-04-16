package com.demo.common.util;

/**
 * Created by lixusheng on 7/28/16.
 */
public class PhoneUtil {

    /**
     * 通用手机号隐藏方法，隐藏中间四位
     */
    public static String maskPhoneNumber(String phoneNumber) {
        return phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7, 11);
    }
}
