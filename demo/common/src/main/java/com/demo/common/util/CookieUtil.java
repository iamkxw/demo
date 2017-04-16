package com.demo.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类
 *
 * @author kxw
 * @version 2017/1/16 16:09
 */
public class CookieUtil {

    /**
     * 根据cookie名从request中获取cookie
     * <p>created by kxw on 2017/1/16 16:09</p>
     */
    public static String getCookieByName(String cookieName, HttpServletRequest request) {
        String cookieValue = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i] != null) {
                    if (StringUtils.equalsIgnoreCase(cookies[i].getName(), cookieName)) {
                        cookieValue = cookies[i].getValue();
                        break;
                    }
                }
            }
        }

        return cookieValue;
    }

    /**
     * 将一个对象以json格式写入cookie中
     * <p>created by kxw on 2017/1/16 16:10</p>
     */
    public static String writeCookie(String cookieName, Object cookieValue, HttpServletResponse response) {
        String cookieValueStr;

        if (cookieValue instanceof String) {
            cookieValueStr = (String) cookieValue;
        } else {
            cookieValueStr = JSON.toJSONString(cookieValue);
        }

        Cookie cookie = new Cookie(cookieName, cookieValueStr);
        cookie.setSecure(false);
        cookie.setMaxAge(5 * 24 * 60 * 60); //设置cookie为5天有效
        response.addCookie(cookie);

        return cookieValueStr;
    }

    /**
     * 通过cookie名和response删除指定cookie
     * <p>created by kxw on 2017/1/16 16:10</p>
     */
    public static void deleteCookie(String cookieName, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, null);

        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
    }
}
