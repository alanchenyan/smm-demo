package com.alanchen.smmdemo.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alan Chen
 * @description
 * @date 2019-11-01
 */
@Api("Swagger测试接口")
@RestController
@RequestMapping("swagger-test")
public class SwaggerTestController {


    @ApiOperation("Swagger 你好")
    @GetMapping
    public String helloSwagger(){
        return "Hello Swagger";
    }
}
