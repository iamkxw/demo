package com.demo.common.enums;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 枚举
 * 页面访问来源
 *
 * @author kxw
 * @version 2017/1/17 18:25
 */
public enum PageSourceType {

    WECHAT_CUSTOMER(1, "微信_用户端", "/page/mobile/auth/signin"),
    WEB_CUSTOMER(2, "网页_用户端", "/web/home/login"),
    WEB_ADMINISTRATOR(3, "网页_运营管理端", "/web/auth/admin/login"),
    WEB_VENDER(4, "网页_供货商管理端", "/web/auth/merchant/login"),
    UNKNOWN(5, "未知", "/");

    private int code;
    private String desc;
    private String loginPage;

    PageSourceType(int code, String desc, String loginPage) {
        this.code = code;
        this.desc = desc;
        this.loginPage = loginPage;
    }

    public static PageSourceType valueOf(int code) {
        switch (code) {
            case 1:
                return WECHAT_CUSTOMER;
            case 2:
                return WEB_CUSTOMER;
            case 3:
                return WEB_ADMINISTRATOR;
            case 4:
                return WEB_VENDER;
            default:
                return UNKNOWN;
        }
    }

    /**
     * 根据访问url判断页面访问来源,决定其未登录时的跳转链接
     * Created by kxw
     */
    public static PageSourceType parsePageSourceByURL(HttpServletRequest request) {
        return parsePageSourceByURL(request.getHeader("Referer"));
    }

    /**
     * 根据访问url判断页面访问来源,决定其未登录时的跳转链接
     * Created by kxw
     */
    public static PageSourceType parsePageSourceByURL(String url) {

        if (StringUtils.startsWith(url, "/web/merchant") || StringUtils.contains(url, "/web/merchant")) {
            return PageSourceType.WEB_VENDER;
        }
        if (StringUtils.startsWith(url, "/web/admin") || StringUtils.contains(url, "/web/admin")) {
            return PageSourceType.WEB_ADMINISTRATOR;
        }
        if (StringUtils.startsWith(url, "/page/mobile") || StringUtils.contains(url, "/page/mobile")) {
            return PageSourceType.WECHAT_CUSTOMER;
        }
        if (StringUtils.startsWith(url, "/web/home") || StringUtils.contains(url, "/web/home")) {
            return PageSourceType.WEB_CUSTOMER;
        }
        return PageSourceType.UNKNOWN;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getLoginPage() {
        return loginPage;
    }
}
