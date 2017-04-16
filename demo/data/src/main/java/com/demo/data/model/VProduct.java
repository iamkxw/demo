package com.demo.data.model;

import com.demo.data.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixusheng on 1/17/17.
 */
public class VProduct {
    private Integer productId;

    private String desc;

    private String name;

    private Byte status;

    private Integer unitPrice;

    public static VProduct parseFromDomain(Product domain) {
        VProduct contract = new VProduct();
        contract.setDesc(domain.getDesc());
        contract.setName(domain.getName());
        contract.setProductId(domain.getProductId());
        contract.setStatus(domain.getStatus());
        contract.setUnitPrice(domain.getUnitPrice());
        return contract;
    }

    public static List<VProduct> parseFromDomainList(List<Product> domains) {
        List<VProduct> contracts = new ArrayList<>();
        domains.forEach(element -> contracts.add(parseFromDomain(element)));
        return contracts;
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }
}
