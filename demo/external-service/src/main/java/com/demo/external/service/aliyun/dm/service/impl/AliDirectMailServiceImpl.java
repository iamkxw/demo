package com.demo.external.service.aliyun.dm.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.BatchSendMailRequest;
import com.aliyuncs.dm.model.v20151123.BatchSendMailResponse;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.demo.external.service.aliyun.dm.config.AliDirectMailSetting;
import com.demo.external.service.aliyun.dm.domain.BatchMailProperty;
import com.demo.external.service.aliyun.dm.service.AliDirectMailService;
import com.demo.common.log.AppLogger;
import com.demo.external.service.aliyun.dm.domain.SingleMailProperty;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 8/24/16.
 */
@Component
public class AliDirectMailServiceImpl implements AliDirectMailService {

    @Override
    public void sendSingleMail(SingleMailProperty sMail) {
        IClientProfile iProfile = DefaultProfile.getProfile(
                AliDirectMailSetting.getRegionId(),
                AliDirectMailSetting.getAccessKey(),
                AliDirectMailSetting.getAccessKeySecret()
        );

        IAcsClient iAcsClient = new DefaultAcsClient(iProfile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //控制台创建的发信地址
            request.setAccountName(sMail.getAccountName());
            //发信人昵称
            request.setFromAlias(sMail.getFromAlias());
            //取值范围0~1: 0为随机账号(推荐,可以更好的统计退信情况);1为发信地址
            request.setAddressType(1);
            //控制台创建的标签
            request.setTagName(sMail.getTagName());
            //是否使用管理控制台中配置的回信地址（状态必须是验证通过）
            request.setReplyToAddress(true);
            //目标地址，多个Email地址可以逗号分隔
            request.setToAddress(sMail.getToAddress());
            //邮件主题
            request.setSubject(sMail.getSubject());
            //邮件正文
            request.setHtmlBody(sMail.getHtmlBody());
            SingleSendMailResponse httpResponse = iAcsClient.getAcsResponse(request);
        } catch (ServerException e) {
            AppLogger.externalServiceAliyunLogger.warn("阿里服务器端异常",e);
        } catch (ClientException e) {
            AppLogger.externalServiceAliyunLogger.warn("阿里云客户端端异常",e);
        }
    }

    @Override
    public void sendMultiMails(BatchMailProperty bMail) {
        IClientProfile iProfile = DefaultProfile.getProfile(
                AliDirectMailSetting.getRegionId(),
                AliDirectMailSetting.getAccessKey(),
                AliDirectMailSetting.getAccessKeySecret()
        );

        IAcsClient iAcsClient = new DefaultAcsClient(iProfile);
        BatchSendMailRequest request = new BatchSendMailRequest();
        try {
            //管理控制台中配置的发信地址
            request.setAccountName(bMail.getAccountName());
            //取值范围0~1: 0为随机账号(推荐,可以更好的统计退信情况);1为发信地址
            request.setAddressType(1);
            //预先创建且通过审核的模板名称
            request.setReceiversName(bMail.getReceiversName());
            //预先创建且上传了收件人的收件人列表名称
            request.setTemplateName(bMail.getTemplateName());
            //邮件标签名称
            request.setTagName(bMail.getTagName());
            BatchSendMailResponse httpResponse = iAcsClient.getAcsResponse(request);
        } catch (Exception e) {
            AppLogger.externalServiceAliyunLogger.warn("阿里云邮件服务异常", e);
        }
    }
}
