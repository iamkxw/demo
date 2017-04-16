package com.demo.external.service.aliyun.dm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 8/24/16.
 */
@Component
public class AliDirectMailSetting {

    private static String regionId;

    private static String accessKey;

    private static String accessKeySecret;

    @Autowired
    private AliDirectMailSetting(@Value("${alibaba.aliyun.directMail.regionId}") String regionId,
                                 @Value("${alibaba.aliyun.directMail.accessKeyId}") String accessKey,
                                 @Value("${alibaba.aliyun.directMail.accessKeySecret}") String accessKeySecret) {
        AliDirectMailSetting.regionId = regionId;
        AliDirectMailSetting.accessKey = accessKey;
        AliDirectMailSetting.accessKeySecret = accessKeySecret;
    }

    public static String getRegionId() {
        return regionId;
    }

    public static void setRegionId(String regionId) {
        AliDirectMailSetting.regionId = regionId;
    }

    public static String getAccessKey() {
        return accessKey;
    }

    public static void setAccessKey(String accessKey) {
        AliDirectMailSetting.accessKey = accessKey;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        AliDirectMailSetting.accessKeySecret = accessKeySecret;
    }
}
