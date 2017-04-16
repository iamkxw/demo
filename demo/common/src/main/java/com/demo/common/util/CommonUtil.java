package com.demo.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 粗分工具类-随时准备整理
 *
 * @author kxw
 * @time 12/1/15 15:41
 */
public class CommonUtil {

    /**
     * 校验手机号是否合法
     *
     * @author kxw
     * @time 11/19/15 13:52
     */
    public static boolean validPhone(String phoneNumber) {

        boolean isValid = false;

        //判空, 为空直接返回无效
        if (StringUtils.isBlank(phoneNumber)) {
            return isValid;
        }

        //正则匹配, 11位数字
        Pattern p = Pattern.compile("^((\\d{11}))$");
        try {
            Matcher m = p.matcher(phoneNumber);
            isValid = m.matches();
        } catch (Exception e) {
            isValid = false;
        }

        return isValid;
    }

    /**
     * 校验手机验证码是否合法
     *
     * @author kxw
     * @time 11/19/15 13:52
     */
    public static boolean validSMSCode(String phoneNumber) {

        boolean isValid = false;

        //判空, 为空直接返回无效
        if (StringUtils.isBlank(phoneNumber)) {
            return isValid;
        }

        //正则匹配, 6位数字
        Pattern p = Pattern.compile("^((\\d{6}))$");
        try {
            Matcher m = p.matcher(phoneNumber);
            isValid = m.matches();
        } catch (Exception e) {
            isValid = false;
        }

        return isValid;
    }
}