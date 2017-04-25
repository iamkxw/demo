package com.demo.service.security;

import com.demo.common.enums.AccountType;
import com.demo.data.domain.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 安全验证工具类
 *
 * @author kxw
 * @version 2017/1/13 16:12
 */
@Component
public class SecurityUtil {

    public static SecurityUtil securityUtil;

    @PostConstruct
    //@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
    public void init() {
        securityUtil = this;
    }

    /**
     * 获取当前用户登录信息
     * Created by Sawyer on 2017/1/19.
     */
    public static Authentication getCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
        //spring security默认启用anonymous用户，SecurityContextHolder.getContext().getAuthentication()不会取到null
    }

    /**
     * 判断用户是否经过认证（登录）
     * Created by Sawyer on 2017/1/19.
     */
    public static boolean isAuthenticated() {
        return !("anonymousUser".equals(getCurrentAuthentication().getPrincipal()));
        //未登录时spring security会将principal设置为anonymousUser
    }

    /**
     * 获取登录用户account信息
     * Created by Sawyer on 2017/1/19.
     */
    public static Account getCurrentAccount() {
        if (isAuthenticated()) {
            return (Account) getCurrentAuthentication().getPrincipal();
        }
        return null;
    }

    /**
     * 判断指定类型用户是否登录
     * Created by Sawyer on 2017/1/19.
     */
    public static boolean isThisRoleAuthenticated(AccountType type) {
        Account account = getCurrentAccount();
        if (account != null) {
            return type == account.getType();
        }
        return false;
    }

    /**
     * 获取登录用户id（日志用）
     * Created by Sawyer on 2017/1/19.
     */
    public static String getCurrentAccountId() {
        if (isAuthenticated()) {
            return String.valueOf(getCurrentAccount().getAccountId());
        }
        return "anonym";
    }
}
