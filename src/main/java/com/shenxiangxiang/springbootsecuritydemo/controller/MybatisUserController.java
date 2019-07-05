package com.shenxiangxiang.springbootsecuritydemo.controller;

import com.shenxiangxiang.springbootsecuritydemo.mapper.UserMapper;
import com.shenxiangxiang.springbootsecuritydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class MybatisUserController {
    private final UserMapper userMapper;

    @Autowired
    public MybatisUserController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @PostMapping("/users/add")
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


}
