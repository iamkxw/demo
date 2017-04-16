package com.demo.common.log;

import com.demo.common.util.HttpUtil;

/**
 * 美颜社日志工具类
 *
 * @Author: kxw
 * @Create: 16:37
 */
public class AppLoggerUtil {

    /**
     * 生成标准的身份验证日志信息
     *
     * @Author: kxw
     */
    public static String genAuthLogMessage(String headMessage) {
        String url = HttpUtil.getCurrentRelativeURL();
        return String.format("%s%nURL: %s", headMessage, url);
    }
}
