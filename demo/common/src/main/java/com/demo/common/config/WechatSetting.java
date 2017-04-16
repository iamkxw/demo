package com.demo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WechatSetting {

    private static String originalId;
    private static String appId;
    private static String appSecret;
    private static String privateToken;
    private static String mchId;
    private static String paySignKey;
    private static String payNotifyUrl;
    private static String payCert;
    private static String testOpenId;

    @Autowired
    public WechatSetting(@Value("${weixin.service.originalId}") String originalId,
                         @Value("${weixin.service.appId}") String appId,
                         @Value("${weixin.service.appSecret}") String appSecret,
                         @Value("${weixin.service.privateToken}") String privateToken,
                         @Value("${weixin.service.mchId}") String mchId,
                         @Value("${weixin.service.paySignKey}") String paySignKey,
                         @Value("${weixin.service.payNotifyUrl}") String payNotifyUrl,
                         @Value("${weixin.service.payCert}") String payCert,
                         @Value("${weixin.service.testOpenId}") String testOpenId) {
        WechatSetting.originalId = originalId;
        WechatSetting.appId = appId;
        WechatSetting.appSecret = appSecret;
        WechatSetting.privateToken = privateToken;
        WechatSetting.mchId = mchId;
        WechatSetting.paySignKey = paySignKey;
        WechatSetting.payNotifyUrl = payNotifyUrl;
        WechatSetting.payCert = payCert;
        WechatSetting.testOpenId = testOpenId;
    }

    public static String getOriginalId() {
        return originalId;
    }

    public static void setOriginalId(String originalId) {
        WechatSetting.originalId = originalId;
    }

    public static String getAppId() {
        return appId;
    }

    public static void setAppId(String appId) {
        WechatSetting.appId = appId;
    }

    public static String getAppSecret() {
        return appSecret;
    }

    public static void setAppSecret(String appSecret) {
        WechatSetting.appSecret = appSecret;
    }

    public static String getPrivateToken() {
        return privateToken;
    }

    public static void setPrivateToken(String privateToken) {
        WechatSetting.privateToken = privateToken;
    }

    public static String getMchId() {
        return mchId;
    }

    public static void setMchId(String mchId) {
        WechatSetting.mchId = mchId;
    }

    public static String getPaySignKey() {
        return paySignKey;
    }

    public static void setPaySignKey(String paySignKey) {
        WechatSetting.paySignKey = paySignKey;
    }

    public static String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public static void setPayNotifyUrl(String payNotifyUrl) {
        WechatSetting.payNotifyUrl = payNotifyUrl;
    }

    public static String getPayCert() {
        return payCert;
    }

    public static void setPayCert(String payCert) {
        WechatSetting.payCert = payCert;
    }

    public static String getTestOpenId() {
        return testOpenId;
    }

    public static void setTestOpenId(String testOpenId) {
        WechatSetting.testOpenId = testOpenId;
    }
}
