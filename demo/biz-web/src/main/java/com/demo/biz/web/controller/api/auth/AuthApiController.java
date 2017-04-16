package com.demo.biz.web.controller.api.auth;

import com.demo.biz.service.account.register.AccountRegisterService;
import com.demo.biz.web.controller.AppController;
import com.demo.common.exception.AppException;
import com.demo.data.domain.Account;
import com.demo.model.view.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthApiController extends AppController {

    @Autowired
    AccountRegisterService accountRegisterService;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @PostMapping(value = "/registry")
    public Object registry(@RequestBody VUser user) throws AppException {
        accountRegisterService.checkBeforeRegisterInfo(user);

        Account newAccount = accountRegisterService.register(user);

        if (newAccount == null || newAccount.getAccountId() < 1) {
            return responseFail("用户创建失败，请重试或联系工作人员");
        }

        return newAccount;
    }
}
