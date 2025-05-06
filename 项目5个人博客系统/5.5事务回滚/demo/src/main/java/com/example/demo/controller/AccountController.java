package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public ReturnT<List<Account>> getAccount() {
        //查询账户
        return accountService.getAccount();
    }

    @GetMapping("/trade")
    public String tradeMoney(@RequestParam("x") int x) {
        if (accountService.tradeMoney(x)) {
            System.out.println("转账成功");
            return "转账成功";
        } else {
            System.out.println("转账失败");
            return "转账失败";
        }
    }
}
