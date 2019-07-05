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
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan("com.shenxiangxiang.springbootsecuritydemo.controller")
public class MyBatisTestApp {
    private static final Logger log = LoggerFactory.getLogger(MyBatisTestApp.class);

    @Autowired
    UserMapper userMapper;




    public static void main(String[] args) {
        SpringApplication.run(MyBatisTestApp.class, args);
    }

    @Bean
    public CommandLineRunner mybatisdemo(UserMapper userMapper) {
        return (args) -> {
            String generatedString = getAlphaNumericString(10);
            User user = new User();
            user.setDisplayName(generatedString);
            user.setUsername(generatedString);
            user.setEnabled(true);
            user.setPasswordHash("abcs");
            userMapper.insert(user);
        };
    }

    static String getAlphaNumericString(int n)
    {

        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }

        // return the resultant string
        return r.toString();
    }

}
