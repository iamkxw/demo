package com.demo.data.repository;

import com.demo.data.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lixusheng on 1/12/17.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * 根据手机号及密码获取用户
     * Created by Sawyer on 2017/1/16.
     */
    Account findByPhoneAndPassword(String phone, String password);

    /**
     * 根据手机号及账号类型获取用户
     * Created by Sawyer on 2017/1/23.
     */
    Account findByPhoneAndType(String phone, byte type);

    /**
     * 根据手机号获取用户
     * Created by Sawyer on 2017/1/16.
     */
    Account findByPhone(String phone);
}
