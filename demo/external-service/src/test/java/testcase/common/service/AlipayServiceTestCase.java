package testcase.common.service;

import base.TestBase;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.demo.external.service.alipay.config.AlipayConfig;
import com.demo.external.service.alipay.domain.AlipayRequest;
import com.demo.external.service.alipay.impl.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class AlipayServiceTestCase extends TestBase {

    @Autowired
    AlipayService alipayService;

    @Test
    public void buildAlipayRequest() {
        try {
            //构建请求
            AlipayRequest alipayRequest = new AlipayRequest();
            alipayRequest.setService(AlipayConfig.getService());
            alipayRequest.setPartner(AlipayConfig.getPartner());
            alipayRequest.setSeller_id(AlipayConfig.getSeller_id());
            alipayRequest.setSeller_email("tech@beauty-inst.com");
            alipayRequest.set_input_charset(AlipayConfig.getInput_charset());
            alipayRequest.setPayment_type(AlipayConfig.getPayment_type());
            alipayRequest.setNotify_url(AlipayConfig.getNotify_url());
            alipayRequest.setReturn_url(AlipayConfig.getReturn_url());
            alipayRequest.setOut_trade_no("test1234256789");
            alipayRequest.setSubject("测试");
            alipayRequest.setTotal_fee("0.01");
            alipayRequest.setShow_url("http://www.taobao.com/product/113714.html");
            alipayRequest.setApp_pay("Y");
            alipayRequest.setBody("测试");

            logger.info(alipayService.buildWapPay(alipayRequest));
        } catch (Exception e) {
            logger.warn(e);
        }
    }

    @Test
    public void queryAlipayOrder() {
        AlipayTradeQueryResponse alipayTradeQueryResponse = alipayService.queryOrder("payment_20161026153344_94_575");
        logger.info(alipayTradeQueryResponse.getBuyerUserId());
    }
}
