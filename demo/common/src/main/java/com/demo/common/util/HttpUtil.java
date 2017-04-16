package com.demo.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * http请求工具类
 * Created by kxw
 *
 * @DateTime 2016/5/7 10:00
 */
public class HttpUtil {

    /**
     * 获取当前请求的url
     *
     * @Author: kxw
     */
    public static String getCurrentRelativeURL() {

        String url = null;

        HttpServletRequest httpServletRequest = getCurrentReuqest();
        if (httpServletRequest != null) {
            url = httpServletRequest.getRequestURI();
        }

        return url;
    }

    /**
     * 获取当前请求的HttpServletRequest
     *
     * @Author: kxw
     */
    public static HttpServletRequest getCurrentReuqest() {

        HttpServletRequest httpServletRequest = null;

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        }

        return httpServletRequest;
    }

    /**
     * 获取完整的请求url
     * 例如: http://stackoverflow.com/myquestion?code=1234
     *
     * @Author: kxw
     */
    public static String getFullURL(HttpServletRequest httpServletRequest) {

        String url;
        String scheme = httpServletRequest.getScheme();
        String serverName = httpServletRequest.getServerName();
        String port = String.valueOf(httpServletRequest.getServerPort());
        port = StringUtils.equalsIgnoreCase(port, "80") ? "" : ":" + port;
        String path = httpServletRequest.getServletPath();

        url = String.format("%s://%s%s%s", scheme, serverName, port, path);
        if (httpServletRequest.getQueryString() != null) {
            url += "?" + httpServletRequest.getQueryString();
        }

        return url;
    }
}