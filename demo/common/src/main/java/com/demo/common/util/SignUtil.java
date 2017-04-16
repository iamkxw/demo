package com.demo.common.util;

import com.demo.common.enums.SignTypeEnum;
import com.demo.common.log.AppLogger;
import com.foxinmy.weixin4j.util.MapUtil;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * 粗分工具类-随时准备整理
 *
 * @author kxw
 * @version 2017/1/18 18:00
 */
public class SignUtil {

    /**
     * 签名,入参为一个object
     * <p>created by kxw on 2017/1/18 18:00</p>
     */
    public static String encode(Object object, SignTypeEnum signTypeEnum) {
        //object对象转化为string
        String input = MapUtil.toJoinString(object, false, false);

        //开始加密
        return encode(input, signTypeEnum);
    }

    /**
     * 对String进行签名
     * <p>created by kxw on 2017/1/18 18:01</p>
     */
    public static String encode(String input, SignTypeEnum signTypeEnum) {

        if (signTypeEnum == null) {
            return null;
        }

        String output;

        try {
            byte[] inputBytes = input.getBytes();
            MessageDigest sha = MessageDigest.getInstance(signTypeEnum.getName());
            if (sha == null) {
                return null;
            }
            sha.update(inputBytes);
            byte[] outputBytes = sha.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte outputByte : outputBytes) {
                hexString.append(String.format("%02X", 0xFF & outputByte));
            }
            output = hexString.toString();
        } catch (Exception e) {
            AppLogger.utilLogger.warn("签名失败", e);
            return null;
        }

        if (StringUtils.isNotBlank(output)) {
            return output.toLowerCase();
        }

        return null;
    }
}