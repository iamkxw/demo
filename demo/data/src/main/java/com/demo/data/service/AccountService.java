package com.demo.data.service;

import com.demo.data.domain.Account;
import com.demo.data.repository.AccountRepository;
import com.demo.common.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lixusheng on 1/12/17.
 */
@Component
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    /**
     * 根据手机号及密码获取用户
     * Created by Sawyer on 2017/1/16.
     */
    public Account findByPhoneAndPassword(String phone, String password) {
        return accountRepository.findByPhoneAndPassword(phone, password);
    }

    /**
     * 根据手机号及账号类型获取用户
     * Created by Sawyer on 2017/1/23.
     */
    public Account findByPhoneAndType(String phone, AccountType type) {
        return accountRepository.findByPhoneAndType(phone, (byte) type.getCode());
    }

    /**
     * 根据手机号获取用户
     * Created by Sawyer on 2017/1/16.
     */
    public Account findByPhone(String phone) {
        return accountRepository.findByPhone(phone);
    }
}
