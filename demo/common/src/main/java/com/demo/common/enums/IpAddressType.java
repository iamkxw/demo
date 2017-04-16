package com.demo.common.enums;

/**
 * 枚举: ip地址类型
 *
 * @author kxw
 * @version 2017/1/16 17:27
 */
public enum IpAddressType {

    PRIVATE(0, "内网ip"), PUBLIC(1, "外网ip"), UNKNOWN(99, "未知");

    private int value;
    private String desc;

    IpAddressType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static IpAddressType valueOf(int status) {
        switch (status) {
            case 0:
                return PRIVATE;
            case 1:
                return PUBLIC;
            default:
                return UNKNOWN;
        }
    }

    public int value() {
        return value;
    }

    public String toString() {
        return this.desc;
    }
}
