package com.demo.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lixusheng on 5/27/16.
 */
public class SessionUtil {

    public static HttpSession getSession(boolean args) {
        RequestAttributes rAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) rAttributes).getRequest();
        return request.getSession();
    }

    /**
     * set parameter to session
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        getSession(true).setAttribute(key, value);
    }

    /**
     * get value via key
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        HttpSession session = getSession(false);
        if (session != null) {
            return session.getAttribute(key);
        } else {
            return null;
        }
    }

    /**
     * remove the corresponding value
     */
    public static void remove(String key) {
        HttpSession session = getSession(false);
        if (session != null) {
            session.removeAttribute(key);
        }
    }

    /**
     * clear the content of session
     */
    public static void clear() {
        HttpSession session = getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    /**
     * 获取当前请求的sessionId
     * <p>created by kxw on 2017/1/17 15:43</p>
     */
    public static String getCurrentSessionId() {
        String sessionId = null;

        if (RequestContextHolder.currentRequestAttributes() != null) {
            sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        }

        return sessionId;
    }
}
