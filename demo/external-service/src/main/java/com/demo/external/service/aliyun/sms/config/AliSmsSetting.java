package com.demo.external.service.aliyun.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 10/12/16.
 */
@Component
public class AliSmsSetting {

    private static String regionId;
    private static String accessKey;
    private static String accessKeySecret;
    private static String signName;
    private static String defaultSmsCode;

    @Autowired
    private AliSmsSetting(
            @Value("${alibaba.aliyun.yunSms.regionId}") String regionId,
            @Value("${alibaba.aliyun.yunSms.accessKeyId}") String accessKey,
            @Value("${alibaba.aliyun.yunSms.accessKeySecret}") String accessKeySecret,
            @Value("${alibaba.aliyun.yunSms.signName}") String signName,
            @Value("${beauty.default.defaultSMSCode}") String defaultSmsCode) {
        AliSmsSetting.accessKey = accessKey;
        AliSmsSetting.accessKeySecret = accessKeySecret;
        AliSmsSetting.regionId = regionId;
        AliSmsSetting.signName = signName;
        AliSmsSetting.defaultSmsCode = defaultSmsCode;
    }

    public static String getRegionId() {
        return regionId;
    }

    public static void setRegionId(String regionId) {
        AliSmsSetting.regionId = regionId;
    }

    public static String getAccessKey() {
        return accessKey;
    }

    public static void setAccessKey(String accessKey) {
        AliSmsSetting.accessKey = accessKey;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        AliSmsSetting.accessKeySecret = accessKeySecret;
    }


    public static String getSignName() {
        return signName;
    }

    public static void setSignName(String signName) {
        AliSmsSetting.signName = signName;
    }

    public static String getDefaultSmsCode() {
        return defaultSmsCode;
    }

    public static void setDefaultSmsCode(String defaultSmsCode) {
        AliSmsSetting.defaultSmsCode = defaultSmsCode;
    }
}
