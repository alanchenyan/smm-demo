package com.alanchen.smmdemo.framework.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Alan Chen
 * @description
 * @date 2019-10-31
 */
//@Configuration
//@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class GlobalSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String DEV_ENVIRONMENT = "dev";

    /**
     * 运行环境：dev/prod/test
     */
    //@Value("${spring.profiles.active}")
    private String active = "prod";

    protected long expiration(){
        return 8 * 1000;
    }


    /**
     * 密码加密及校验方式
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Web资源权限控制
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web)  {
        super.configure(web);
//        //swagger-ui start
        web.ignoring().antMatchers("/v2/api-docs/**");
        web.ignoring().antMatchers("/swagger.json");
        web.ignoring().antMatchers("/swagger-ui.html");
        web.ignoring().antMatchers("/swagger-resources/**");
        web.ignoring().antMatchers("/webjars/**");
        //swagger-ui end
    }

    /**
     * HTTP请求权限控制
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //本地开发环境关闭权限控制，方便测试
        if(DEV_ENVIRONMENT.equals(active)){
            http.cors().and().csrf().disable().authorizeRequests()
                    .antMatchers("/**").permitAll();
        }else{
            http.cors().and().csrf().disable().authorizeRequests()
                    .antMatchers("/auth/green-channel").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .addFilter(new JwtLoginFilter(authenticationManager(),expiration()))
                    .addFilter(new JwtAuthenticationFilter(authenticationManager()));
        }

        // 禁用 SESSION、JSESSIONID
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}