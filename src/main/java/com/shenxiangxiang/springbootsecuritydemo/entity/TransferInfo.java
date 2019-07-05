package com.shenxiangxiang.springbootsecuritydemo.entity;

import org.springframework.stereotype.Component;

@Component
public class TransferInfo {
    private String accountNo;
    private String amount;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
