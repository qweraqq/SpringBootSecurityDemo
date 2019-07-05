package com.shenxiangxiang.springbootsecuritydemo.controller;

import com.shenxiangxiang.springbootsecuritydemo.entity.TransferInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JsonCsrfController {
    @Autowired
    public JsonCsrfController(){}

    @GetMapping(value="/csrf/json_transfer")
    public String csrfReadme(){
        return "CSRF demo <br>" +
                "curl -d '{\"accountNo\":\"123456\", \"amount\":\"100\"}' -H \"Content-Type: application/json\" " +
                "-X POST http://127.0.0.1:8080/csrf/json_transfer";
    }

    @PostMapping(value = "/csrf/json_transfer")
    public String transfer(@RequestBody TransferInfo transferInfo) {
        return "Transfer to " + transferInfo.getAccountNo() + " with amount " + transferInfo.getAmount();
    }
}

