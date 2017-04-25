package com.demo.model.view;

import com.demo.data.domain.Account;

public class VUser {

    private Account account;
    private String type;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
