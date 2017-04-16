package com.demo.external.service.aliyun.sms.biz;

import com.demo.common.exception.AppException;
import com.demo.external.service.aliyun.sms.domain.AliSmsParams;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 10/14/16.
 */
@Component
public interface SendSmsService {

    void sendSMSCode(String phoneNumber) throws AppException;

    void sendSMSCode(String phoneNumber, String templateName) throws AppException;

    void sendTemplateSMS(AliSmsParams aliSmsParams) throws AppException;
}
