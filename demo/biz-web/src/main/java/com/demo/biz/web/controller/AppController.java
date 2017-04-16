package com.demo.biz.web.controller;

import com.demo.common.exception.AppException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.Map;

@Component
public class AppController extends BaseController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        logErrorRequest(exception);

        BindingResult bindingResult = exception.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String error = fieldError.getDefaultMessage();
            return responseFail(error);
        }
        return responseFail("您的请求在controller上进行数据绑定时失败");
    }

    @ExceptionHandler({TypeMismatchException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    public Map<String, Object> typeMismatchExceptionHandler(TypeMismatchException exception) {
        logErrorRequest(exception);

        return responseFail("您的请求数据格式错误");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Map<String, Object> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException exception) {
        logErrorRequest(exception);

        return responseFail("您的请求方法暂不支持");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Map<String, Object> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException exception) {
        logErrorRequest(exception);

        return responseFail("您的请求缺少参数");
    }

    @ExceptionHandler({AppException.class, HttpClientErrorException.class, IOException.class, Exception.class})
    @ResponseBody
    public Map<String, Object> iOExceptionHandler(IOException exception) {
        logErrorRequest(exception);

        return responseFail(exception.getMessage());
    }
}
