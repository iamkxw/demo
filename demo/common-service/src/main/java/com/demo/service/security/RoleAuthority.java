package com.demo.service.security;

import com.demo.common.enums.AccountType;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * 账号权限
 * Created by Sawyer on 2017/1/17.
 */
public class RoleAuthority implements GrantedAuthority {

    String authority;

    public RoleAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public static Set<RoleAuthority> getRoleAuthorities(AccountType type) {
        switch (type) {
            case ADMIN:
                return Sets.newHashSet(new RoleAuthority("ROLE_ADMIN"));
            case VENDOR:
                return Sets.newHashSet(new RoleAuthority("ROLE_VENDOR"));
            case AGENT:
                return Sets.newHashSet(new RoleAuthority("ROLE_AGENT"));
        }
        return null;
    }
}
