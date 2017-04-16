package com.demo.external.service.aliyun.sms.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.demo.common.exception.AppException;
import com.demo.external.service.aliyun.sms.config.AliSmsSetting;
import com.demo.external.service.aliyun.sms.service.AliSmsService;
import com.demo.common.log.AppLogger;
import com.demo.external.service.aliyun.sms.domain.AliSmsModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 10/12/16.
 */
@Component
public class AliSmsServiceImpl implements AliSmsService {

    private static final String exceptionMsg = "阿里云短信服务调用异常";

    @Override
    public void sendAliSms(AliSmsModel aliSmsModel) throws Exception {
        try {
            IClientProfile iProfile = DefaultProfile.getProfile(
                    AliSmsSetting.getRegionId(),
                    AliSmsSetting.getAccessKey(),
                    AliSmsSetting.getAccessKeySecret()
            );
            IAcsClient iAcsClient = new DefaultAcsClient(iProfile);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");

            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setRecNum(aliSmsModel.getRecNum());
            request.setTemplateCode(aliSmsModel.getTemplateCode());
            request.setSignName(AliSmsSetting.getSignName());
            request.setParamString(aliSmsModel.getParamString());

            SingleSendSmsResponse response = iAcsClient.getAcsResponse(request);

            if (response == null || StringUtils.isBlank(response.getModel())) {
                AppLogger.smsLogger.warn("阿里云短信服务调用异常，返回结果为空");
                throw new AppException(exceptionMsg);
            }
        } catch (ServerException e) {
            AppLogger.smsLogger.warn("阿里云短信服务调用异常，服务端异常", e);
            throw new AppException(exceptionMsg);
        } catch (ClientException e) {
            AppLogger.smsLogger.warn("阿里云短信服务调用异常，客户端异常", e);
            throw new AppException(exceptionMsg);
        } catch (Exception e) {
            AppLogger.smsLogger.warn("阿里云短信服务调用异常，未知异常", e);
            throw new AppException(exceptionMsg);
        }
    }
}
