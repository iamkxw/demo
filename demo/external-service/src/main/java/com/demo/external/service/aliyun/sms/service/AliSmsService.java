package com.demo.external.service.aliyun.sms.service;

import com.demo.external.service.aliyun.sms.domain.AliSmsModel;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 10/12/16.
 */
@Component
public interface AliSmsService {

    void sendAliSms(AliSmsModel aliSmsModel) throws Exception;
}
