package com.shenxiangxiang.springbootsecuritydemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(ignoreResourceNotFound=false,value="classpath:application-h2.properties")
@EnableAutoConfiguration
@ComponentScan("com.shenxiangxiang.springbootsecuritydemo.controller")
public class HelloWorldApp {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldApp.class);
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApp.class, args);
    }

}
