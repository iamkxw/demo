package com.demo.external.service.alipay.domain;

import org.apache.commons.lang3.StringUtils;

/**
 * POJO
 * 支付宝支付请求
 *
 * @author kxw
 * @version 2017/1/19 18:44
 */
public class AlipayRequest {

    //↓↓↓↓↓↓↓↓↓↓基础请求参数↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private String service;

    private String partner;

    private String _input_charset;

    private String sign_type;

    private String sign;

    private String notify_url;

    private String return_url;

    //↓↓↓↓↓↓↓↓↓↓附加请求参数↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    private String out_trade_no;

    private String subject;

    private String total_fee;

    private String seller_id;

    private String seller_email;

    private String payment_type;

    private String show_url;

    private String body;

    private String it_b_pay;

    private String extern_token;

    private String otherfee;

    private String airticket;

    private String rn_check;

    private String buyer_cert_no;

    private String buyer_real_name;

    private String scene;

    private String hb_fq_param;

    private String goods_type;

    //是否使用支付宝客户端支付: app_pay=Y：尝试唤起支付宝客户端进行支付，若用户未安装支付宝，则继续使用wap收银台进行支付。商户若为APP，则需在APP的webview中增加alipays协议处理逻辑。
    private String app_pay;

    private String promo_params;

    //↓↓↓↓↓↓↓↓↓↓固定方法↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String get_input_charset() {
        return _input_charset;
    }

    public void set_input_charset(String _input_charset) {
        this._input_charset = _input_charset;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        subject = StringUtils.replace(subject, " ", ""); //去除可能出现的空格
        subject = StringUtils.replace(subject, "\n", ""); //去除可能出现的回车
        this.subject = subject;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getShow_url() {
        return show_url;
    }

    public void setShow_url(String show_url) {
        this.show_url = show_url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        body = StringUtils.replace(body, " ", ""); //去除可能出现的空格
        body = StringUtils.replace(body, "\n", ""); //去除可能出现的回车
        this.body = body;
    }

    public String getIt_b_pay() {
        return it_b_pay;
    }

    public void setIt_b_pay(String it_b_pay) {
        this.it_b_pay = it_b_pay;
    }

    public String getExtern_token() {
        return extern_token;
    }

    public void setExtern_token(String extern_token) {
        this.extern_token = extern_token;
    }

    public String getOtherfee() {
        return otherfee;
    }

    public void setOtherfee(String otherfee) {
        this.otherfee = otherfee;
    }

    public String getAirticket() {
        return airticket;
    }

    public void setAirticket(String airticket) {
        this.airticket = airticket;
    }

    public String getRn_check() {
        return rn_check;
    }

    public void setRn_check(String rn_check) {
        this.rn_check = rn_check;
    }

    public String getBuyer_cert_no() {
        return buyer_cert_no;
    }

    public void setBuyer_cert_no(String buyer_cert_no) {
        this.buyer_cert_no = buyer_cert_no;
    }

    public String getBuyer_real_name() {
        return buyer_real_name;
    }

    public void setBuyer_real_name(String buyer_real_name) {
        this.buyer_real_name = buyer_real_name;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getHb_fq_param() {
        return hb_fq_param;
    }

    public void setHb_fq_param(String hb_fq_param) {
        this.hb_fq_param = hb_fq_param;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getApp_pay() {
        return app_pay;
    }

    public void setApp_pay(String app_pay) {
        this.app_pay = app_pay;
    }

    public String getPromo_params() {
        return promo_params;
    }

    public void setPromo_params(String promo_params) {
        this.promo_params = promo_params;
    }
}
