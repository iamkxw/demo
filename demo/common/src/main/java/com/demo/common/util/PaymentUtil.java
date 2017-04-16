package com.demo.common.util;

import java.util.Random;

/**
 * 支付工具类
 * Created by iamkxw on 2016/4/19.
 */
public class PaymentUtil {

    /**
     * 生成商户订单号
     *
     * @Author: kxw
     */
    public static String genMerchantPaymentOrder(int orderId) {

        //生成时间戳
        String timePart = TimeUtil.getCurrentTimeStr();

        //三位随机数字
        Random randomNumber = new Random();
        int random = randomNumber.nextInt(900) + 100;

        return String.format("payment_%s_%s_%s", timePart, orderId, random);
    }

    /**
     * 生成上传图片文件名
     * Created by kxw
     */
    public static String genTestPaymentOrder() {

        //生成时间戳
        String timePart = TimeUtil.getCurrentTimeStr();

        //三位随机数字
        Random randomNumber = new Random();
        int random = randomNumber.nextInt(900) + 100;

        return String.format("payment_test_%s_%s", timePart, random);
    }
}
