package com.demo.common.util;

import com.demo.common.enums.IpAddressType;
import com.demo.common.log.AppLogger;
import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 物理机工具类
 *
 * @author kxw
 * @version 2016/12/7 14:02
 */
public class HostUtil {

    /**
     * 获取当前主机的mac地址
     * <p>created by kxw on 2016/12/7 14:02</p>
     */
    public static String getCurrentMac() {
        String macStr;
        //获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            if (mac == null) {
                AppLogger.utilLogger.warn("获取当前主机mac为空");
                return null;
            }
        } catch (Exception e) {
            AppLogger.utilLogger.warn("获取当前主机mac地址失败", e);
            return null;
        }

        //下面代码是把mac地址拼装成String
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length() == 1 ? 0 + s : s);
        }
        macStr = sb.toString().toUpperCase();

        return macStr;
    }

    /**
     * 获取本机ip地址
     * <p>created by kxw on 2016/12/7 14:03</p>
     */
    public static String getIpAddress(IpAddressType ipAddressType) {

        String localIp = null;
        String netIp = null;
        String ipAddress;

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            InetAddress ip;
            boolean found = false;
            while (networkInterfaces.hasMoreElements() && !found) {
                NetworkInterface ni = networkInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().contains(":")) {// 外网IP
                        netIp = ip.getHostAddress();
                    } else if (ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().contains(":")) {// 内网IP
                        localIp = ip.getHostAddress();
                        found = true;
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            AppLogger.utilLogger.warn("ip地址获取异常", e);
        }

        switch (ipAddressType) {
            case PRIVATE:
                ipAddress = localIp;
                break;
            case PUBLIC:
                ipAddress = netIp;
                break;
            default:
                ipAddress = localIp;
        }

        if (StringUtils.isBlank(ipAddress) || StringUtils.length(ipAddress) > 15) {
            try {
                ipAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception e) {
                AppLogger.utilLogger.warn("默认ip地址获取失败", e);
            }
        }

        return ipAddress;
    }
}
