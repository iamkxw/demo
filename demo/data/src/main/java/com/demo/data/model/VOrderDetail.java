package com.demo.data.model;

import com.demo.data.domain.OrderDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixusheng on 1/17/17.
 */
public class VOrderDetail {

    private Integer orderDetailId;

    private Integer quantity;

    private Integer totalPrice;

    private Integer unitPrice;

    public static VOrderDetail parseFromDomain(OrderDetail domain) {
        VOrderDetail contract = new VOrderDetail();
        contract.setUnitPrice(domain.getUnitPrice());
        contract.setOrderDetailId(domain.getOrderDetailId());
        contract.setQuantity(domain.getQuantity());
        contract.setTotalPrice(domain.getTotalPrice());
        return contract;
    }

    public static List<VOrderDetail> parseFromDomains(List<OrderDetail> domains) {
        List<VOrderDetail> contracts = new ArrayList<>();
        domains.forEach(element -> contracts.add(parseFromDomain(element)));
        return contracts;
    }
    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }
}
