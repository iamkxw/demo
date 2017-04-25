package com.demo.biz.service.account.register;

import com.demo.common.exception.AppException;
import com.demo.data.domain.Account;
import com.demo.data.service.AccountService;
import com.demo.model.view.VLoginInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务服务：账户验证
 *
 * @author kxw
 * @version 2017/2/10 14:37
 */
@Service
public class AccountLoginService {

    @Autowired
    AccountService accountService;

    public Account login(VLoginInfo vLoginInfo) {
        return null;
    }

    public boolean checkBeforeLogin(VLoginInfo vLoginInfo) throws AppException {
        boolean isLegal = false;

        if (vLoginInfo == null) {
            throw new AppException("登录请求非法，请求解析为空");
        }
        if (StringUtils.isBlank(vLoginInfo.getAccountName())) {
            throw new AppException("登录请求非法，账户名为空");
        }
        if (StringUtils.isBlank(vLoginInfo.getAccountPassword())) {
            throw new AppException("登录请求非法，密码为空");
        }

        return isLegal;
    }
}
