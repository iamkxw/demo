package com.demo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 账号认证
 * Created by Sawyer on 2017/1/17.
 */
@Service
public class AccountAuthProvider implements AuthenticationProvider {

    @Autowired
    AccountDetailService accountDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String phone = token.getName();
        UserDetails accountDetails = null;
        if (phone != null) {
            accountDetails = accountDetailService.loadUserByUsername(phone);
        }
        if (accountDetails == null) {
            //如果找不到用户
            throw new UsernameNotFoundException("该用户不存在");
        } else if (!accountDetails.getPassword().equals(token.getCredentials())) {
            //密码错误
            throw new BadCredentialsException("密码有误");
        } else if (!accountDetails.isEnabled()) {
            //账户被禁用
            throw new DisabledException("该账户已被禁用");
        }
        //验证通过，给予相应权限
        return new UsernamePasswordAuthenticationToken(accountDetails, token.getCredentials(), accountDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //当authentication的类型是UsernamePasswordAuthenticationToken进入该AccountAuthService认证授权
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
