package com.demo.common.log;

import org.apache.log4j.Logger;

/**
 * 系统日志工具类
 *
 * @author kxw
 * @version 2016/12/21 15:35
 */
public class AppLogger {
    // 基础日志
    public static Logger rootLogger = Logger.getLogger(AppLogger.class);
    public static Logger sysLogger = Logger.getLogger("sysLogger");
    public static Logger testLogger = Logger.getLogger("testLogger");
    public static Logger requestLogger = Logger.getLogger("requestLogger");
    public static Logger exceptionLogger = Logger.getLogger("exceptionLogger");
    // 组件日志
    private static Logger springframeworkSecurityLogger = Logger.getLogger("org.springframework.security"); //禁止使用
    // 内部日志
    public static Logger runLogger = Logger.getLogger("runLogger");
    public static Logger payLogger = Logger.getLogger("payLogger");
    public static Logger smsLogger = Logger.getLogger("smsLogger");
    public static Logger weixinLogger = Logger.getLogger("weixinLogger");
    public static Logger orderLogger = Logger.getLogger("orderLogger");
    public static Logger taskLogger = Logger.getLogger("taskLogger");
    public static Logger utilLogger = Logger.getLogger("utilLogger");
    public static Logger authenticationLogger = Logger.getLogger("authenticationLogger");
    // 外部服务日志
    public static Logger externalServiceAlipayLogger = Logger.getLogger("externalServiceAlipayLogger");
    public static Logger externalServiceWeixinpayLogger = Logger.getLogger("externalServiceWeixinpayLogger");
    public static Logger externalServiceAliyunLogger = Logger.getLogger("externalServiceAliyunLogger");
    public static Logger externalServiceWeixinLogger = Logger.getLogger("externalServiceWeixinLogger");
}
