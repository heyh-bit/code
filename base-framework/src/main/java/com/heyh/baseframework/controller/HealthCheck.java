package com.heyh.baseframework.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@RestController = @Controller + @@ResponseBody
@RequestMapping("/health")
public class HealthCheck {

    @GetMapping("/hello")//    @GetMapping("/hello") = @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello";
    }
}
