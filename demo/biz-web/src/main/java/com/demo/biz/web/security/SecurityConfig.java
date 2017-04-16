package com.demo.biz.web.security;

import com.demo.biz.web.filter.APIRequestFilter;
import com.demo.biz.web.filter.RequestLogFilter;
import com.demo.service.security.AccountAuthProvider;
import com.demo.service.security.AccountDetailService;
import com.demo.service.security.AuthAccessDeniedHandler;
import com.demo.service.security.UserAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

/**
 * Spring Security 配置
 * Created by Sawyer on 2017/1/16.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountAuthProvider accountAuthProvider; //身份认证器
    @Autowired
    UserAuthenticationEntryPoint userAuthenticationEntryPoint; //未验证用户访问受限资源处理器
    @Autowired
    AuthAccessDeniedHandler authAccessDeniedHandler; //验证用户权限不匹配处理器
    @Autowired
    AccountDetailService accountDetailService; //账户信息服务
    @Autowired
    APIRequestFilter apiRequestFilter;
    @Autowired
    RequestLogFilter requestLogFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/home", "/page/auth/registry").permitAll()
                .antMatchers("/agent").hasRole("AGENT")
                .antMatchers("/vendor").hasRole("VENDOR")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/page/auth/login").failureUrl("/page/auth/login/error")
                .and()
                .rememberMe().userDetailsService(accountDetailService)
                .and()
                .exceptionHandling().accessDeniedHandler(authAccessDeniedHandler)
                .and()
                .addFilterAfter(apiRequestFilter, AnonymousAuthenticationFilter.class)
                .addFilterBefore(requestLogFilter, RequestLogFilter.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(accountAuthProvider);
    }
}
