package com.demo.service.security;

import com.demo.data.domain.Account;
import com.demo.data.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 用户账号生成服务
 * Created by Sawyer on 2017/1/16.
 */
@Component
public class AccountDetailService implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Account account = accountService.findByPhone(phone);
        if (account == null) {
            throw new UsernameNotFoundException("该账号不存在");
        } else {
            return new AccountDetails(account);
        }
    }

    /**
     * 将账号信息转变为userDetail以供SpringSecurity认证
     * Created by Sawyer on 2017/1/16.
     */
    private final class AccountDetails extends Account implements UserDetails {

        AccountDetails(Account account) {
            setAccountId(account.getAccountId());
            setPhone(account.getPhone());
            setPassword(account.getPassword());
            setIsValid(account.getIsValid());
            setRegisteredTime(account.getRegisteredTime());
            setType(account.getType());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return RoleAuthority.getRoleAuthorities(getType());
        }

        @Override
        public String getUsername() {
            return getPhone();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return getIsValid();
        }
    }
}
