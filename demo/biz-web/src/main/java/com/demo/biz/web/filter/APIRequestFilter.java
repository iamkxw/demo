package com.demo.biz.web.filter;

import com.demo.common.constant.SecurityCookieConstant;
import com.demo.common.util.RequestUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 身份验证拦截器
 * 识别微信账户（服务号）
 * 为安全验证第一个拦截器
 *
 * @author kxw
 * @version 2016/12/29 16:24
 */
public class APIRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (response != null) {
            response.addHeader(SecurityCookieConstant.IS_API_REQUEST, "true");
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        boolean shouldNotFilter = true;

        if (RequestUtil.isAPIRequest(request)) {
            shouldNotFilter = false;
        }

        return shouldNotFilter;
    }
}