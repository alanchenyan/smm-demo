package com.alanchen.smmdemo.test.config;

import com.alanchen.smmdemo.framework.swagger.GlobalSwaggerWebMvcConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Alan Chen
 * @description
 * @date 2019-11-01
 */
@EnableSwagger2
@Configuration
public class MySwagger extends GlobalSwaggerWebMvcConfig {

    @Override
    protected String title(){
        return "AC接口文档";
    }

    @Override
    protected String description(){
        return "AC接口文档描述";
    }

    @Override
    protected String version(){
        return "AC 1.0.0";
    }

}
