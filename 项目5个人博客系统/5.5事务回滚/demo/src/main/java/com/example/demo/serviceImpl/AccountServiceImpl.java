package com.example.demo.serviceImpl;

import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.AccountService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    public ReturnT<List<Account>> getAccount() {
        try {
            return ReturnT.Success(accountMapper.getAccount());
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    //正确
//    @Transactional
//    public void tradeMoney() throws Exception {
//        //先增加余额
//        accountMapper.reduceMoney();
//        accountMapper.addMoney();
//        //然后遇到故障
//        throw new RuntimeException("发生异常了..");
//    }

    //正确
    @Transactional(rollbackFor = SQLException.class)
    public boolean tradeMoney(int x) {
        try {
            //2转账给1
            accountMapper.reduceMoney();
            int i = 1 / x;//人为设置异常
            accountMapper.addMoney();
            return true;
        } catch (Exception e) {
            //手工回滚异常
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    //正确
//    @Transactional(rollbackFor = SQLException.class)
//    public void tradeMoney() throws Exception {
//        //2转账给1
//        accountMapper.reduceMoney();
//        accountMapper.addMoney();
//        //然后遇到故障
//        throw new SQLException("发生异常了..");
//    }

//    Spring的默认的事务规则是遇到运行异常（RuntimeException）和程序错误（Error）才会回滚。
//    如果想针对非检测异常进行事务回滚，可以在@Transactional 注解里使用rollbackFor 属性明确指定异常

    //错误
//    @Transactional
//    public void tradeMoney() throws Exception {
//        //2转账给1
//        accountMapper.reduceMoney();
//        accountMapper.addMoney();
//        //然后遇到故障
//        throw new SQLException("发生异常了..");
//    }
}
