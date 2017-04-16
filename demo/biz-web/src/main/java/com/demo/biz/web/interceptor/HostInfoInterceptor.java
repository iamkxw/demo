package com.demo.biz.web.interceptor;

import com.demo.common.config.HostSetting;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * 主机相关信息拦截器
 * 主要用于动态生成静态文件版本号
 *
 * @author kxw
 * @version 2016/12/7 16:34
 */
@Component
@Order(100)
public class HostInfoInterceptor implements WebRequestInterceptor {

    private static final String STATICS_VERSION = "staticsVersion";

    @Override
    public void preHandle(WebRequest request) throws Exception {
        //do nothing
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        if (model != null) {
            model.addAttribute(HostInfoInterceptor.STATICS_VERSION, HostSetting.getAppStartTime());
        }
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        //do nothing
    }
}