package com.shenxiangxiang.springbootsecuritydemo.controller;

import org.owasp.esapi.ESAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XssController {
    @GetMapping("xss/reflected")
    @ResponseBody
    public String reflectedXss(@RequestParam String payload){
        return payload;
    }

    @GetMapping("xss/esapiencoded")
    @ResponseBody
    public String esapiEncodedXss(@RequestParam String payload){
        return ESAPI.encoder().encodeForHTML(payload);
    }
}
