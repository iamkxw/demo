package com.demo.data.exception;

/**
 * 异常: DB层服务处理异常
 *
 * @author kxw
 * @version 2016/12/12 14:27
 */
public class DemoDBException extends Exception {

    private static final long serialVersionUID = 4753128611475635065L;

    public DemoDBException(String message) {
        super(message);
    }

    public DemoDBException(Throwable cause) {
        super(cause);
    }
}