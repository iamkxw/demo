package com.demo.external.service.alipay.util;

import com.demo.external.service.alipay.config.AlipayConfig;
import com.demo.external.service.alipay.domain.AlipayNotifyResult;
import com.demo.external.service.alipay.util.sign.MD5;
import com.demo.external.service.alipay.util.sign.RSA;
import com.demo.common.log.AppLogger;
import com.demo.common.util.MapUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * 支付宝核心支付工具类
 *
 * @Author: kxw
 * @Create: 9:25
 */
public class AlipayCoreUtil {

    /**
     * 除去数组中的空值和签名参数
     *
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (StringUtils.isBlank(value)
                    || "sign".equalsIgnoreCase(key)
                    || "sign_type".equalsIgnoreCase(key)) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * 生成签名结果
     *
     * @param sPara 要签名的数组
     * @return 签名结果字符串
     */
    public static String buildRequestMysign(Map<String, String> sPara) {
        String prestr = createLinkString(sPara); //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        String mysign = "";
        if (StringUtils.equalsIgnoreCase(AlipayConfig.getSign_type(), "RSA")) {
            AppLogger.externalServiceWeixinpayLogger.info("即将使用RSA私钥" + AlipayConfig.getPrivate_key() + "对字符串" + prestr + "进行RSA签名操作");
            mysign = RSA.sign(prestr, AlipayConfig.getPrivate_key(), AlipayConfig.getInput_charset());
            AppLogger.externalServiceWeixinpayLogger.info("签名成功，结果为" + mysign);
        }
        if (StringUtils.equalsIgnoreCase(AlipayConfig.getSign_type(), "MD5")) {
            AppLogger.externalServiceWeixinpayLogger.info("即将使用MD5密钥" + AlipayConfig.getMd5_private_key() + "对字符串" + prestr + "进行MD5签名操作");
            mysign = MD5.sign(prestr, AlipayConfig.getPrivate_key(), AlipayConfig.getInput_charset());
            AppLogger.externalServiceWeixinpayLogger.info("签名成功，结果为" + mysign);
        }
        return mysign;
    }

    /**
     * 验证消息是否是支付宝发出的合法消息
     *
     * @param alipayNotifyResult 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(AlipayNotifyResult alipayNotifyResult) {
        Map<String, String> params = new HashMap<>();

        //将请求参数模型转化为map
        try {
            params = MapUtil.getFieldVlaue(alipayNotifyResult);
        } catch (Exception e) {
            AppLogger.externalServiceWeixinpayLogger.warn("支付宝异步通知模型解析失败", e);
        }

        return verify(params);
    }

    /**
     * 验证消息是否是支付宝发出的合法消息
     *
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params) {

        //1. 校验是否支付宝服务器发送的请求
        String responseTxt = "false";
        if (params.get("notify_id") != null) {
            String notify_id = params.get("notify_id");
            responseTxt = verifyResponse(notify_id);
        }

        //2. 校验请求是否拥有合法签名
        String sign = "";
        if (params.get("sign") != null) {
            sign = params.get("sign");
        }
        boolean isSign = getSignVerify(params, sign);

        //3. 两者都为true的时候才可以返回成功
        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     *
     * @param Params 通知返回来的参数数组
     * @param sign   比对的签名结果
     * @return 生成的签名结果
     */
    private static boolean getSignVerify(Map<String, String> Params, String sign) {
        //1. 过滤空值、sign与sign_type参数
        Map<String, String> sParaNew = AlipayCoreUtil.paraFilter(Params);
        //2. 进行排序
        sParaNew = new TreeMap<>(sParaNew);
        //3. 获取待签名字符串
        String preSignStr = AlipayCoreUtil.createLinkString(sParaNew);
        //4. 获得签名验证结果
        boolean isSign = false;
        if (StringUtils.equalsIgnoreCase(AlipayConfig.getSign_type(), "RSA")) {
            isSign = RSA.verify(preSignStr, sign, AlipayConfig.getAlipay_public_key(), AlipayConfig.getInput_charset());
        }
        return isSign;
    }

    /**
     * 获取远程服务器ATN结果,验证返回URL
     *
     * @param notify_id 通知校验ID
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String verifyResponse(String notify_id) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

        String partner = AlipayConfig.getPartner();
        String verifyUrl = AlipayConfig.getHttpsVerifyUrl() + "partner=" + partner + "&notify_id=" + notify_id;

        return checkUrl(verifyUrl);
    }

    /**
     * 获取远程服务器ATN结果
     *
     * @param urlvalue 指定URL路径地址
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                    .getInputStream()));
            inputLine = in.readLine();
        } catch (Exception e) {
            AppLogger.externalServiceWeixinpayLogger.warn("支付宝远程验签异常", e);
            inputLine = "";
        }

        return inputLine;
    }
}
