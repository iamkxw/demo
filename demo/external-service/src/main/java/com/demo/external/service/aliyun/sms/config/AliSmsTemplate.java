package com.demo.external.service.aliyun.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 10/12/16.
 */
@Component
public class AliSmsTemplate {

    private static String verifyCommonTemplate;
    private static String quickRegisterVerifyTemplate;
    private static String customerOrderSuccessTemplate;
    private static String customerOrderVerifyTemplate;
    private static String customerOrderCancelTemplate;
    private static String customerOrderRefundApplyTemplate;
    private static String batchOrderSuccessTemplate;
    private static String adminRefundApplyNotification;

    @Autowired
    public AliSmsTemplate(
            @Value("${alibaba.aliyun.yunSms.template.verifyCommonTemplate}") String verifyCommonTemplate,
            @Value("${alibaba.aliyun.yunSms.template.quickRegisterVerifyTemplate}") String quickRegisterVerifyTemplate,
            @Value("${alibaba.aliyun.yunSms.template.customerOrderSuccessTemplate}") String customerOrderSuccessTemplate,
            @Value("${alibaba.aliyun.yunSms.template.customerOrderVerifyTemplate}") String customerOrderVerifyTemplate,
            @Value("${alibaba.aliyun.yunSms.template.customerOrderCancelTemplate}") String customerOrderCancelTemplate,
            @Value("${alibaba.aliyun.yunSms.template.customerOrderRefundApplyTemplate}") String customerOrderRefundApplyTemplate,
            @Value("${alibaba.aliyun.yunSms.template.batchOrderSuccessTemplate}") String batchOrderSuccessTemplate,
            @Value("${alibaba.aliyun.yunSms.template.adminRefundApplyNotification}") String adminRefundApplyNotification
    ) {
        AliSmsTemplate.verifyCommonTemplate = verifyCommonTemplate;
        AliSmsTemplate.quickRegisterVerifyTemplate = quickRegisterVerifyTemplate;
        AliSmsTemplate.customerOrderSuccessTemplate = customerOrderSuccessTemplate;
        AliSmsTemplate.customerOrderVerifyTemplate = customerOrderVerifyTemplate;
        AliSmsTemplate.customerOrderCancelTemplate = customerOrderCancelTemplate;
        AliSmsTemplate.customerOrderRefundApplyTemplate = customerOrderRefundApplyTemplate;
        AliSmsTemplate.batchOrderSuccessTemplate = batchOrderSuccessTemplate;
        AliSmsTemplate.adminRefundApplyNotification = adminRefundApplyNotification;
    }

    public static String getVerifyCommonTemplate() {
        return verifyCommonTemplate;
    }

    public static void setVerifyCommonTemplate(String verifyCommonTemplate) {
        AliSmsTemplate.verifyCommonTemplate = verifyCommonTemplate;
    }

    public static String getQuickRegisterVerifyTemplate() {
        return quickRegisterVerifyTemplate;
    }

    public static void setQuickRegisterVerifyTemplate(String quickRegisterVerifyTemplate) {
        AliSmsTemplate.quickRegisterVerifyTemplate = quickRegisterVerifyTemplate;
    }

    public static String getCustomerOrderSuccessTemplate() {
        return customerOrderSuccessTemplate;
    }

    public static void setCustomerOrderSuccessTemplate(String customerOrderSuccessTemplate) {
        AliSmsTemplate.customerOrderSuccessTemplate = customerOrderSuccessTemplate;
    }

    public static String getCustomerOrderVerifyTemplate() {
        return customerOrderVerifyTemplate;
    }

    public static void setCustomerOrderVerifyTemplate(String customerOrderVerifyTemplate) {
        AliSmsTemplate.customerOrderVerifyTemplate = customerOrderVerifyTemplate;
    }

    public static String getCustomerOrderCancelTemplate() {
        return customerOrderCancelTemplate;
    }

    public static void setCustomerOrderCancelTemplate(String customerOrderCancelTemplate) {
        AliSmsTemplate.customerOrderCancelTemplate = customerOrderCancelTemplate;
    }

    public static String getCustomerOrderRefundApplyTemplate() {
        return customerOrderRefundApplyTemplate;
    }

    public static void setCustomerOrderRefundApplyTemplate(String customerOrderRefundApplyTemplate) {
        AliSmsTemplate.customerOrderRefundApplyTemplate = customerOrderRefundApplyTemplate;
    }

    public static String getBatchOrderSuccessTemplate() {
        return batchOrderSuccessTemplate;
    }

    public static void setBatchOrderSuccessTemplate(String batchOrderSuccessTemplate) {
        AliSmsTemplate.batchOrderSuccessTemplate = batchOrderSuccessTemplate;
    }

    public static String getAdminRefundApplyNotification() {
        return adminRefundApplyNotification;
    }

    public static void setAdminRefundApplyNotification(String adminRefundApplyNotification) {
        AliSmsTemplate.adminRefundApplyNotification = adminRefundApplyNotification;
    }
}
