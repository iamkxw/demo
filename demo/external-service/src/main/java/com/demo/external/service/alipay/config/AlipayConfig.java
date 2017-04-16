package com.demo.external.service.alipay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 *
 * @author kxw
 * @version 2017/1/19 18:43
 */
@Component
public class AlipayConfig {

    private static String alipay_server_url = "https://openapi.alipay.com/gateway.do";

    private static String format = "json";

    // 支付宝应用id
    private static String appId = "";

    // 支付宝接口网关
    private static String alipay_gateway = "";

    // 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    private static String partner = "";

    // 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
    private static String seller_id = "";

    // 商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
    private static String private_key = "";

    // MD5签名形式的密钥
    private static String md5_private_key = "";

    // 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
    private static String alipay_public_key =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB" +
                    "/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    private static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    private static String return_url = "";

    // 签名方式
    private static String sign_type = "RSA";

    // 字符编码格式 目前支持 gbk 或 utf-8
    private static String input_charset = "utf-8";

    // 支付类型 ，无需修改
    private static String payment_type = "1";

    // 调用的接口名，无需修改
    private static String service = "alipay.wap.create.direct.pay.by.user";

    // 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
    private static String anti_phishing_key = "";

    // 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
    private static String exter_invoke_ip = "";

    // 支付宝通知校验
    private static String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    @Autowired
    public AlipayConfig(@Value("${alibaba.alipay.appId}") String appId,
                        @Value("${alibaba.alipay.partner}") String partner,
                        @Value("${alibaba.alipay.seller_id}") String seller_id,
                        @Value("${alibaba.alipay.rsa_private_key}") String rsa_private_key,
                        @Value("${alibaba.alipay.alipay_public_key}") String alipay_public_key,
                        @Value("${alibaba.alipay.md5_token}") String md5_token,
                        @Value("${alibaba.alipay.alipay_gateway}") String alipay_gateway,
                        @Value("${alibaba.alipay.alipay_notify_url}") String alipay_notify_url,
                        @Value("${alibaba.alipay.alipay_return_url}") String alipay_return_url) {
        AlipayConfig.appId = appId;
        AlipayConfig.partner = partner;
        AlipayConfig.seller_id = seller_id;
        AlipayConfig.alipay_public_key = alipay_public_key;
        AlipayConfig.private_key = rsa_private_key;
        AlipayConfig.md5_private_key = md5_token;
        AlipayConfig.alipay_gateway = alipay_gateway;
        AlipayConfig.return_url = alipay_return_url;
        AlipayConfig.notify_url = alipay_notify_url;
    }

    public static String getAlipay_server_url() {
        return alipay_server_url;
    }

    public static void setAlipay_server_url(String alipay_server_url) {
        AlipayConfig.alipay_server_url = alipay_server_url;
    }

    public static String getFormat() {
        return format;
    }

    public static void setFormat(String format) {
        AlipayConfig.format = format;
    }

    public static String getAppId() {
        return appId;
    }

    public static void setAppId(String appId) {
        AlipayConfig.appId = appId;
    }

    public static String getAlipay_gateway() {
        return alipay_gateway;
    }

    public static void setAlipay_gateway(String alipay_gateway) {
        AlipayConfig.alipay_gateway = alipay_gateway;
    }

    public static String getPartner() {
        return partner;
    }

    public static void setPartner(String partner) {
        AlipayConfig.partner = partner;
    }

    public static String getSeller_id() {
        return seller_id;
    }

    public static void setSeller_id(String seller_id) {
        AlipayConfig.seller_id = seller_id;
    }

    public static String getPrivate_key() {
        return private_key;
    }

    public static void setPrivate_key(String private_key) {
        AlipayConfig.private_key = private_key;
    }

    public static String getMd5_private_key() {
        return md5_private_key;
    }

    public static void setMd5_private_key(String md5_private_key) {
        AlipayConfig.md5_private_key = md5_private_key;
    }

    public static String getAlipay_public_key() {
        return alipay_public_key;
    }

    public static void setAlipay_public_key(String alipay_public_key) {
        AlipayConfig.alipay_public_key = alipay_public_key;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        AlipayConfig.notify_url = notify_url;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        AlipayConfig.return_url = return_url;
    }

    public static String getSign_type() {
        return sign_type;
    }

    public static void setSign_type(String sign_type) {
        AlipayConfig.sign_type = sign_type;
    }

    public static String getInput_charset() {
        return input_charset;
    }

    public static void setInput_charset(String input_charset) {
        AlipayConfig.input_charset = input_charset;
    }

    public static String getPayment_type() {
        return payment_type;
    }

    public static void setPayment_type(String payment_type) {
        AlipayConfig.payment_type = payment_type;
    }

    public static String getService() {
        return service;
    }

    public static void setService(String service) {
        AlipayConfig.service = service;
    }

    public static String getAnti_phishing_key() {
        return anti_phishing_key;
    }

    public static void setAnti_phishing_key(String anti_phishing_key) {
        AlipayConfig.anti_phishing_key = anti_phishing_key;
    }

    public static String getExter_invoke_ip() {
        return exter_invoke_ip;
    }

    public static void setExter_invoke_ip(String exter_invoke_ip) {
        AlipayConfig.exter_invoke_ip = exter_invoke_ip;
    }

    public static String getHttpsVerifyUrl() {
        return HTTPS_VERIFY_URL;
    }

    public static void setHttpsVerifyUrl(String httpsVerifyUrl) {
        HTTPS_VERIFY_URL = httpsVerifyUrl;
    }
}