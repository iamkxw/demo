package com.demo.common.config;

import com.demo.common.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置项: host相关信息
 *
 * @author kxw
 * @version 2017/1/17 15:48
 */
@Component
public class HostSetting {

    private static String domain;
    private static String appStartTime = TimeUtil.getCurrentTimeStr();
    private static String localIpAddress = "";

    @Autowired
    public HostSetting(@Value("${host.domain}") String domain) {
        HostSetting.setDomain(domain);
    }

    public static String getDomain() {
        return domain;
    }

    public static void setDomain(String domain) {
        HostSetting.domain = domain;
    }

    public static String getAppStartTime() {
        return appStartTime;
    }

    public static void setAppStartTime(String appStartTime) {
        HostSetting.appStartTime = appStartTime;
    }

    public static String getLocalIpAddress() {
        return localIpAddress;
    }

    public static void setLocalIpAddress(String localIpAddress) {
        HostSetting.localIpAddress = localIpAddress;
    }
}
