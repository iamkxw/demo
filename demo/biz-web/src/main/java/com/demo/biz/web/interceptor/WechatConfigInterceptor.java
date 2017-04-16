package com.demo.biz.web.interceptor;

import com.demo.common.config.WechatSetting;
import com.demo.common.constant.WechatConfigConst;
import com.demo.common.enums.SignTypeEnum;
import com.demo.common.log.AppLogger;
import com.demo.common.util.RequestUtil;
import com.demo.common.util.SignUtil;
import com.demo.model.context.AppContextHolder;
import com.foxinmy.weixin4j.util.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 微信拦截器:
 * 用于初始化微信JSSDK;
 *
 * @author kxw
 * @version 2017/1/18 17:32
 */
@Component
@Order(102)
public class WechatConfigInterceptor implements WebRequestInterceptor {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public void preHandle(WebRequest request) throws Exception {
        //判断是否微信操作环境
        if (RequestUtil.isFromWechatBrowser(httpServletRequest)) {
            //如果是微信环境塞微环境标示
            request.setAttribute(WechatConfigConst.WX_CONFIG_IS_FROM_WEIXIN, true, 0);
            AppContextHolder.getContext().setFromWechatBrowser(true);
            //如果是微信环境查找微信用户
        }
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        //对于微信环境初始化JSSDK的配置
        if (RequestUtil.isFromWechatBrowser(httpServletRequest)
                && model != null) {
            try {
                SortedMap<Object, Object> params = new TreeMap<>();
                //设置openId
                model.addAttribute(WechatConfigConst.WX_CONFIG_OPENID, String.valueOf(request.getAttribute(WechatConfigConst.WX_CONFIG_OPENID, 0)));
                //设置appId
                model.addAttribute(WechatConfigConst.WX_CONFIG_APPID, WechatSetting.getAppId());
                //设置ticket
                params.put(WechatConfigConst.JSAPI_TICKET, "test");
                //设置随机字符串
                String randomStr = RandomUtil.generateString(32);
                model.addAttribute(WechatConfigConst.WX_CONFIG_NONCESTR, randomStr);
                params.put(WechatConfigConst.NONCESTR, randomStr);
                //设置当前时间
                Long timestamp = System.currentTimeMillis();
                model.addAttribute(WechatConfigConst.WX_CONFIG_TIMESTAMP, timestamp);
                params.put(WechatConfigConst.TIMESTAMP, timestamp);
                //设置当前网页地址
                String url;
                url = StringUtils.isNotBlank(httpServletRequest.getQueryString()) ? String.format("%s?%s", httpServletRequest.getRequestURL(),
                        httpServletRequest.getQueryString()) : String.format("%s", httpServletRequest.getRequestURL());
                params.put(WechatConfigConst.URL, url);
                //设置签名值(ticket)
                String signature = SignUtil.encode(params, SignTypeEnum.SHA1);
                model.addAttribute(WechatConfigConst.WX_CONFIG_SIGNATURE, signature);
            } catch (Exception e) {
                AppLogger.weixinLogger.warn("微信jssdk配置初始化异常", e);
            }
        }
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        //do nothing
    }
}