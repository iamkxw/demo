package com.demo.biz.web.controller;

import com.demo.biz.web.config.constant.ResponseConstant;
import com.demo.common.log.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目基础controller
 *
 * @author kxw
 * @version 2017/2/10 14:37
 */
@Component
public class BaseController {

    @Autowired
    HttpServletRequest httpServletRequest;

    /**
     * 通用正常返回
     */
    @ResponseBody
    public Map<String, Object> responseOK(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put(ResponseConstant.RESPONSE_DATA, data);
        result.put(ResponseConstant.RESPONSE_STATUS, 0);
        result.put(ResponseConstant.RESPONSE_RESULT, "SUCCESS");
        result.put(ResponseConstant.RESPONSE_MESSAGE, "");

        return result;
    }

    @ResponseBody
    public Map<String, Object> responseFail(String errorMsg) {
        return this.responseFail(null, errorMsg);
    }

    @ResponseBody
    public Map<String, Object> responseFail(Object data) {
        return this.responseFail(data, "请求处理失败");
    }

    /**
     * 通用错误返回
     */
    @ResponseBody
    public Map<String, Object> responseFail(Object data, String errorMsg) {
        Map<String, Object> result = new HashMap<>();
        result.put(ResponseConstant.RESPONSE_DATA, data);
        result.put(ResponseConstant.RESPONSE_STATUS, 1);
        result.put(ResponseConstant.RESPONSE_RESULT, "FAIL");
        result.put(ResponseConstant.RESPONSE_MESSAGE, errorMsg);

        return result;
    }

    /**
     * 格式化打印报错信息
     */
    void logErrorRequest(Exception e) {
        String info = String.format("报错API URL: %s%nQuery String: %s",
                httpServletRequest.getRequestURI(),
                httpServletRequest.getQueryString());
        AppLogger.runLogger.warn(info);
        AppLogger.exceptionLogger.warn(e);
        String ipInfo = "报错访问者IP信息：" + httpServletRequest.getRemoteAddr() + "," + httpServletRequest.getRemoteHost();
        AppLogger.runLogger.warn(ipInfo);
    }
}
