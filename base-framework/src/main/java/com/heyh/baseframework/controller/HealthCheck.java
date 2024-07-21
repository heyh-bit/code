package com.heyh.baseframework.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@RestController = @Controller + @@ResponseBody
@RequestMapping("/health")
@Api(tags = "项目健康检查")
public class HealthCheck {

    @ApiOperation("say hello")
    @GetMapping("/hello")//    @GetMapping("/hello") = @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello";
    }
}
