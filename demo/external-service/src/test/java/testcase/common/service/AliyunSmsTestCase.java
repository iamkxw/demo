package testcase.common.service;

import base.TestBase;
import com.demo.external.service.aliyun.sms.biz.SendSmsService;
import com.demo.external.service.aliyun.sms.config.AliSmsSetting;
import com.demo.external.service.aliyun.sms.config.AliSmsTemplate;
import com.demo.external.service.aliyun.sms.domain.AliSmsModel;
import com.demo.external.service.aliyun.sms.domain.AliSmsParams;
import com.demo.external.service.aliyun.sms.service.AliSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by lixusheng on 10/13/16.
 */
public class AliyunSmsTestCase extends TestBase {

    @Autowired
    AliSmsService aliSmsService;

    @Autowired
    SendSmsService sendSmsService;

    @Test()
    public void smsTestCase() throws Exception {
        AliSmsModel model = new AliSmsModel();
        //        model.setParamString("{\"string\":\"test\"}");
        model.setParamString("{\"\":\"\"}");
        model.setSignName("美颜社测试");
        model.setRecNum("15988143289");
        model.setTemplateCode("SMS_17855177");
        aliSmsService.sendAliSms(model);
    }

    @Test()
    public void smsRefundTest() throws Exception {
        AliSmsModel aliSmsModel = new AliSmsModel();
        aliSmsModel.setSignName("美颜社");
        aliSmsModel.setParamString("{\"\":\"\"}");
        aliSmsModel.setTemplateCode(AliSmsTemplate.getCustomerOrderRefundApplyTemplate());
        StringBuffer buffer = new StringBuffer();
        buffer.append("15988143289,").append("15757129351,").append("13336195265,").append("13758149243");
        aliSmsModel.setRecNum(buffer.toString());
        aliSmsService.sendAliSms(aliSmsModel);
    }

    @Test()
    public void smsRefund() throws Exception {
        AliSmsParams aliSmsParams = new AliSmsParams();
        aliSmsParams.setName(AliSmsSetting.getSignName());
        aliSmsParams.setOrderId("12345");
        aliSmsParams.setTemplate(AliSmsTemplate.getCustomerOrderRefundApplyTemplate());
        aliSmsParams.setMobilePhoneNumber("15988143289");
        sendSmsService.sendTemplateSMS(aliSmsParams);
    }
}
