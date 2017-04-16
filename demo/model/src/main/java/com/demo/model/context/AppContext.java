package com.demo.model.context;

/**
 * 美颜社全局变量POJO模型
 *
 * @author kxw
 * @version 2016/12/29 17:22
 */
public class AppContext {

    private Boolean isFromWechatBrowser = false;
    private int fontTotalAmount = 0; //前端总金额
    private int fontGoodAmount = 0; //前端优惠后总金额
    private int fontOnlinePayAmount = 0; //前端线上支付总金
    private int backendTotalAmount = 0; //后端计算订单总金额
    private int backendGoodAmount = 0; //后端计算优惠后总金额
    private int backendOnlinePayAmount = 0; //后端计算线上支付总金额

    public Boolean getFromWechatBrowser() {
        return isFromWechatBrowser;
    }

    public void setFromWechatBrowser(Boolean fromWechatBrowser) {
        isFromWechatBrowser = fromWechatBrowser;
    }

    public int getFontTotalAmount() {
        return fontTotalAmount;
    }

    public void setFontTotalAmount(int fontTotalAmount) {
        this.fontTotalAmount = fontTotalAmount;
    }

    public int getFontGoodAmount() {
        return fontGoodAmount;
    }

    public void setFontGoodAmount(int fontGoodAmount) {
        this.fontGoodAmount = fontGoodAmount;
    }

    public int getFontOnlinePayAmount() {
        return fontOnlinePayAmount;
    }

    public void setFontOnlinePayAmount(int fontOnlinePayAmount) {
        this.fontOnlinePayAmount = fontOnlinePayAmount;
    }

    public int getBackendTotalAmount() {
        return backendTotalAmount;
    }

    public void setBackendTotalAmount(int backendTotalAmount) {
        this.backendTotalAmount = backendTotalAmount;
    }

    public int getBackendGoodAmount() {
        return backendGoodAmount;
    }

    public void setBackendGoodAmount(int backendGoodAmount) {
        this.backendGoodAmount = backendGoodAmount;
    }

    public int getBackendOnlinePayAmount() {
        return backendOnlinePayAmount;
    }

    public void setBackendOnlinePayAmount(int backendOnlinePayAmount) {
        this.backendOnlinePayAmount = backendOnlinePayAmount;
    }
}
