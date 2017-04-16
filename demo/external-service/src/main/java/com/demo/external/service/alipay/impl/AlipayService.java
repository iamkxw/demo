package com.demo.external.service.alipay.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.demo.external.service.alipay.config.AlipayConfig;
import com.demo.external.service.alipay.domain.AlipayNotifyResult;
import com.demo.external.service.alipay.domain.AlipayRequest;
import com.demo.external.service.alipay.util.AlipayCoreUtil;
import com.demo.common.log.AppLogger;
import com.demo.common.util.MapUtil;
import org.apache.catalina.util.URLEncoder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 支付宝支付服务
 *
 * @author kxw
 * @version 2017/1/18 17:27
 */
@Service
public class AlipayService {

    /**
     * 创建移动网页支付请求
     * <p>created by kxw on 2017/1/18 17:28</p>
     */
    public String buildWapPay(AlipayRequest alipayRequest) {
        String url;

        //构建请求参数
        if (alipayRequest == null || StringUtils.isBlank(alipayRequest.getOut_trade_no())) {
            AppLogger.externalServiceWeixinpayLogger.warn("支付请求参数非法");
            return null;
        }

        //处理请求参数转变为map
        Map<String, String> paramsMap;
        try {
            paramsMap = MapUtil.getFieldVlaue(alipayRequest);
            AppLogger.externalServiceWeixinpayLogger.info(paramsMap);
        } catch (Exception e) {
            AppLogger.externalServiceWeixinpayLogger.warn("支付请求转化为map数据格式异常", e);
            return null;
        }

        //进行签名操作
        //1.除去数组中的空值和签名参数
        Map<String, String> para = AlipayCoreUtil.paraFilter(paramsMap);
        AppLogger.externalServiceWeixinpayLogger.info(para);
        //2.对数组中的参数进行ASCII码递增排序
        SortedMap<String, String> sortPara = new TreeMap<>(para);
        AppLogger.externalServiceWeixinpayLogger.info(sortPara);
        //3.进行签名
        //签名结果与签名方式加入请求提交参数组中
        String mySign = AlipayCoreUtil.buildRequestMysign(sortPara);
        String mySignEncoded = new URLEncoder().encode(mySign, "UTF-8"); //支付宝签名参数
        sortPara.put("sign", mySignEncoded);
        sortPara.put("sign_type", AlipayConfig.getSign_type());
        //4.将得到的最终提交参数进行拼接
        String paraStr = AlipayCoreUtil.createLinkString(sortPara);

        //构建请求连接
        url = String.format("%s%s", AlipayConfig.getAlipay_gateway(), paraStr);

        return url;
    }

    /**
     * 检查异步通知是否合法
     * <p>created by kxw on 2017/1/18 17:28</p>
     */
    public boolean isValidAlipayNotify(AlipayNotifyResult alipayNotifyResult) {
        boolean isValid;

        isValid = AlipayCoreUtil.verify(alipayNotifyResult);

        return isValid;
    }

    /**
     * alipay.trade.query (统一收单线下交易查询)
     * <p>created by kxw on 2017/1/18 17:30</p>
     */
    public AlipayTradeQueryResponse queryOrder(String merchantNum) {
        //组件查询客户端
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.getAlipay_server_url(), AlipayConfig.getAppId(), AlipayConfig.getPrivate_key(),
                AlipayConfig.getFormat(), AlipayConfig.getInput_charset(), AlipayConfig.getAlipay_public_key());
        //组件查询请求
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"" + merchantNum + "\"" +
                "}");
        //获取查询结果
        AlipayTradeQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (Exception e) {
            AppLogger.externalServiceAlipayLogger.warn("支付宝订单查询异常", e);
        }

        return response;
    }
}