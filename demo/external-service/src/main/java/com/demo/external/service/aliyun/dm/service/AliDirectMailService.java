package com.demo.external.service.aliyun.dm.service;

import com.demo.external.service.aliyun.dm.domain.BatchMailProperty;
import com.demo.external.service.aliyun.dm.domain.SingleMailProperty;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 8/24/16.
 */
@Component
public interface AliDirectMailService {

    void sendSingleMail(SingleMailProperty sMail);

    void sendMultiMails(BatchMailProperty bMail);
}
