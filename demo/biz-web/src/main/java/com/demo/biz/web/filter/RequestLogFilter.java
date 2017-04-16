package com.demo.biz.web.filter;

import com.demo.common.log.AppLogger;
import com.demo.common.util.SessionUtil;
import com.demo.model.context.AppContextHolder;
import com.demo.service.security.SecurityUtil;
import org.apache.log4j.MDC;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求日志过滤器
 *
 * @author kxw
 * @version 2016/12/20 17:27
 */
public class RequestLogFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        MDC.put("sessionId", SessionUtil.getCurrentSessionId());
        MDC.put("currentAccount", SecurityUtil.getCurrentAccountId());
        AppLogger.requestLogger.info(getLogMessage("用户请求处理开始", request));
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        AppLogger.requestLogger.info(getLogMessage("用户请求处理结束,并清空该处理线程的线程变量", request));
        AppContextHolder.clearContext();
    }

    private String getLogMessage(String headMessage, HttpServletRequest request) {
        return String.format("%s%n请求地址:%s  (%s)%n请求参数: %s%n请求来源: %s",
                headMessage,
                request.getRequestURI(),
                request.getMethod(),
                request.getQueryString(),
                request.getRemoteAddr() + "(" + request.getRemoteHost() + ")");
    }
}