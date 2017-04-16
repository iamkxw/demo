package com.demo.common.enums;

/**
 * 枚举: 订单状态
 *
 * @Author: kxw
 * @Create: 15:06
 */
public enum OrderStatus {

    Submitted(0, "已提交", "订单初始化"),
    Created(1, "已创建", "N/A"),
    Cancelled(2, "已撤销", "N/A"),
    Invalid(3, "付款逾期失效", "N/A"),
    Paid(4, "已支付", "未核销"),
    Expired(5, "未核销已过期", "未核销已过期"),
    Completed(6, "已完成", "已核销"),
    Rated(7, "已评价", "已核销"),
    Refunded(8, "已退款", "已过期"),
    PaidFailed(9, "支付失败", "N/A"),
    RefundSubmitted(10, "退款申请已提交", "N/A"),
    RefundInProgress(11, "退款支付处理中", "N/A"),
    RefundVerified(12, "退款申请已审核", "N/A"),
    RefundCompleted(13, "退款申请已完成", "N/A"),
    Unknown(99, "未知", "N/A");

    private int statusCode;
    private String statusDesc;
    private String verificationStatusDesc;

    OrderStatus(int statusCode, String statusDesc, String verificationStatusDesc) {
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
        this.verificationStatusDesc = verificationStatusDesc;
    }

    public static OrderStatus valueOf(int status) {
        switch (status) {
            case 0:
                return Submitted;
            case 1:
                return Created;
            case 2:
                return Cancelled;
            case 3:
                return Invalid;
            case 4:
                return Paid;
            case 5:
                return Expired;
            case 6:
                return Completed;
            case 7:
                return Rated;
            case 8:
                return Refunded;
            case 9:
                return PaidFailed;
            case 10:
                return RefundSubmitted;
            case 11:
                return RefundInProgress;
            case 12:
                return RefundVerified;
            case 13:
                return RefundCompleted;
            default:
                return Unknown;
        }
    }

    public int value() {
        return statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public String getVerificationStatusDesc() {
        return verificationStatusDesc;
    }
}
