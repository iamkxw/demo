package com.demo.service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SpringSecurity相关bean配置
 * Created by Sawyer on 2017/1/20.
 */
@Configuration
public class SecurityBeanConfig {

    /**
     * 使bCryptPasswordEncoder成为bean
     * Created by Sawyer on 2017/1/20.
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

