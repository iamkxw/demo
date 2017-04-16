package com.demo.common.exception;

/**
 * 工具类-异常(全局使用)
 *
 * @author kxw
 * @version 2017/1/17 16:11
 */
public class AppException extends Exception {

    private static final long serialVersionUID = 4753128611475635065L;

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}