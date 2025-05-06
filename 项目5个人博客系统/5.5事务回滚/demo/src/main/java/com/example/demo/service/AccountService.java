package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.utils.ReturnT;

import java.util.List;

public interface AccountService {
    public ReturnT<List<Account>> getAccount();

    public boolean tradeMoney(int x);
}
