package com.alanchen.smmdemo.boss.auth;

import com.alanchen.smmdemo.framework.auth.GlobalSecurityConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author Alan Chen
 * @description
 * @date 2019-11-01
 */
@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class MySecurityConfiguration extends GlobalSecurityConfiguration {

    @Override
    protected long expiration(){
        return 100 * 1000;
    }

}
