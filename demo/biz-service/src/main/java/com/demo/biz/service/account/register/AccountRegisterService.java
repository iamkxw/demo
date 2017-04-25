package com.demo.biz.service.account.register;

import com.demo.common.exception.AppException;
import com.demo.data.domain.Account;
import com.demo.data.service.AccountService;
import com.demo.model.view.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务服务：账户注册服务
 *
 * @author kxw
 * @version 2017/2/10 14:37
 */
@Service
public class AccountRegisterService {

    @Autowired
    AccountService accountService;

    public Account register(VUser user) {
        return null;
    }

    public boolean checkBeforeRegisterInfo(VUser vUser) throws AppException {
        boolean isLegal = false;

        if (vUser == null
                || vUser.getAccount() == null) {
            throw new AppException("创建请求非法，请求解析为空");
        }

        return isLegal;
    }
}
