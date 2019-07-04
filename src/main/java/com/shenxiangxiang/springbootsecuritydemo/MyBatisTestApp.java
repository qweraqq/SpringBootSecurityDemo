package com.shenxiangxiang.springbootsecuritydemo;


import com.shenxiangxiang.springbootsecuritydemo.mapper.UserMapper;
import com.shenxiangxiang.springbootsecuritydemo.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@PropertySource(ignoreResourceNotFound=false, value= "classpath:mybatis-application.properties")
@RestController
@EnableAutoConfiguration
public class MyBatisTestApp {
    private static final Logger log = LoggerFactory.getLogger(MyBatisTestApp.class);

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/")
    String home() {
        return "Hello world";
    }

    @PostMapping("/users")
    ResponseEntity<String> addUserDao(@Valid @RequestBody User user) {
        // persisting the user
        userMapper.insert(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return (List<User>) userMapper.getAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyBatisTestApp.class, args);
    }

    @Bean
    public CommandLineRunner mybatisdemo(UserMapper userMapper) {
        return (args) -> {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            User user = new User();
            user.setDisplayName(generatedString);
            user.setUsername(generatedString);
            user.setEnabled(true);
            user.setPasswordHash("abcs");
            userMapper.insert(user);
        };
    }

}
