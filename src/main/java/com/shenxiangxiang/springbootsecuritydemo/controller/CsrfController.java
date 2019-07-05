package com.shenxiangxiang.springbootsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CsrfController {

    @Autowired
    public CsrfController(){}

    @GetMapping(value="/csrf/transfer")
    @ResponseBody
    public String csrfReadme(){
        return "CSRF demo <br> curl -X POST http://127.0.0.1:8080/csrf/json_transfer " +
                "-H 'Accept: */*' -H 'Content-Type: application/json' " +
                "-d '{\"accountNo\": \"123456\",\"amount\": \"100\"}'";
    }

    @PostMapping(value = "/csrf/transfer")
    @ResponseBody
    public String transfer(@RequestParam("accountNo") String accountNo, @RequestParam("amount") String amount) {
        return "Transfer to " + accountNo + " with amount " + amount;
    }
}
