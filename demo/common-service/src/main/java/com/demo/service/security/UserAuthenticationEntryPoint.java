package com.demo.service.security;

import com.demo.common.util.RequestUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * spring security验证入口
 *
 * @author kxw
 * @version 2017/1/13 14:20
 */
@Service
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {

        //判断当前的请求类型是否为前端异步请求
        if (RequestUtil.isAjaxRequest(httpServletRequest)) {
            httpServletResponse.setStatus(401);
            //TODO 默认配置login登陆成功以后如何跳转指定页面
            httpServletResponse.addHeader("loginPath", "/login");
        } else {
            if (!httpServletResponse.isCommitted()) {
                httpServletResponse.sendRedirect("/login");
            }
        }
    }
}
