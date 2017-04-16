package com.demo.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求工具类
 *
 * @author kxw
 * @version 2016/12/30 15:13
 */
public class RequestUtil {

    /**
     * 是否是非功能性请求
     * 例如statics静态文件请求,health健康检查请求...
     * <p>created by kxw on 2017/1/13 17:15</p>
     */
    public static boolean isFunctionalRequest(HttpServletRequest httpServletRequest) {
        boolean isFunctionalRequest = true;

        if (httpServletRequest != null &&
                StringUtils.startsWithAny(httpServletRequest.getRequestURI(),
                        "/statics",
                        "/health",
                        "/favicon.ico")) {
            isFunctionalRequest = false;
        }

        return isFunctionalRequest;
    }

    /**
     * 是否是页面请求
     * <p>created by kxw on 2017/1/13 17:15</p>
     */
    public static boolean isPageRequest(HttpServletRequest httpServletRequest) {
        boolean isPageRequest = false;

        if (httpServletRequest != null
                && StringUtils.startsWithAny(httpServletRequest.getRequestURI(), "/page/mobile")) {
            isPageRequest = true;
        }

        return isPageRequest;
    }

    /**
     * 是否是页面请求
     * <p>created by kxw on 2017/1/13 17:15</p>
     */
    public static boolean isAPIRequest(HttpServletRequest httpServletRequest) {
        boolean isPageRequest = false;

        if (httpServletRequest != null
                && StringUtils.startsWithAny(httpServletRequest.getRequestURI(), "/api/")) {
            isPageRequest = true;
        }

        return isPageRequest;
    }

    /**
     * 是否微信浏览器请求
     * <p>created by kxw on 2017/1/18 17:35</p>
     */
    public static boolean isFromWechatBrowser(HttpServletRequest httpServletRequest) {
        boolean isFromWechatBrowser = false;

        if (httpServletRequest.getHeader("User-Agent") != null
                && StringUtils.containsIgnoreCase(httpServletRequest.getHeader("User-Agent"), "micromessenger")) {
            isFromWechatBrowser = true;
        }

        return isFromWechatBrowser;
    }

    /**
     * 是否微信浏览器请求
     * <p>created by kxw on 2017/1/18 17:35</p>
     */
    public static boolean isAjaxRequest(HttpServletRequest httpServletRequest) {
        return StringUtils.equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"), "XMLHttpRequest");
    }
}
