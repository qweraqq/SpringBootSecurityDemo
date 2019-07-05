package com.shenxiangxiang.springbootsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    public HelloWorldController(){}

    @RequestMapping("/")
    String helloWorld() {
        return "Hello world";
    }
}
