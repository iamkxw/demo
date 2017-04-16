package com.demo.common.enums;

/**
 * 枚举
 * 签名类型
 *
 * @author kxw
 * @version 2017/1/18 18:01
 */
public enum SignTypeEnum {

    MD5(1, "MD5"), SHA1(2, "SHA-1");

    private int code;
    private String name;

    SignTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
