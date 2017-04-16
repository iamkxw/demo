package com.demo.common.enums;

/**
 * Created by Sawyer on 2017/1/16.
 */
public enum AccountType {

    ADMIN(1, "系统管理员"), VENDOR(2, "供货商"), AGENT(3, "代理商"), UNKNOWN(99, "非法");

    private int code;
    private String desc;

    AccountType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AccountType valueOf(int type) {
        switch (type) {
            case 1:
                return ADMIN;
            case 2:
                return VENDOR;
            case 3:
                return AGENT;
            default:
                return UNKNOWN;
        }
    }

    public int value() {
        return code;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
