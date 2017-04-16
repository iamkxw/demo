package com.demo.model.view;

import com.demo.data.domain.Account;
import com.demo.data.domain.Admin;
import com.demo.data.domain.Agent;
import com.demo.data.domain.Vendor;

/**
 * 用户信息
 * Created by Sawyer on 2017/1/23.
 */
public class VUser {

    private Account account;
    private Admin admin;
    private Agent agent;
    private Vendor vendor;
    private String type;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
