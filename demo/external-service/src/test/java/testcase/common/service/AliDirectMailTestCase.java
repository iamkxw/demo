package testcase.common.service;

import base.TestBase;
import com.demo.external.service.aliyun.dm.config.AliDMReceiversNameList;
import com.demo.external.service.aliyun.dm.domain.BatchMailProperty;
import com.demo.external.service.aliyun.dm.domain.SingleMailProperty;
import com.demo.external.service.aliyun.dm.service.AliDirectMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by lixusheng on 8/24/16.
 */
public class AliDirectMailTestCase extends TestBase {

    @Autowired
    AliDirectMailService aliDirectMailService;

    @Test()
    public void aliDMTestCase() {
        BatchMailProperty batchMailProperty = new BatchMailProperty();
        batchMailProperty.setTagName("test");
        batchMailProperty.setAccountName("adminnotify@admin.notify.beauty-inst.com");
        batchMailProperty.setTemplateName("测试");
        batchMailProperty.setReceiversName("notify_all");

        aliDirectMailService.sendMultiMails(batchMailProperty);

    }

    @Test()
    public void aliDMSingleMail() {
        SingleMailProperty singleMail = new SingleMailProperty();
        singleMail.setAccountName("adminnotify@admin.notify.beauty-inst.com");
        singleMail.setAddressType(1);
        singleMail.setSubject("退款申请通知");
        singleMail.setReplyToAddress(false);
        singleMail.setToAddress(AliDMReceiversNameList.receivers);
        singleMail.setTagName("退款");
        singleMail.setHtmlBody("收到新的退款请求，请及时处理！");
        aliDirectMailService.sendSingleMail(singleMail);
    }
}
