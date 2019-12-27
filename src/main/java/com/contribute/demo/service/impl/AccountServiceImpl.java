package com.contribute.demo.service.impl;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Usermessage;
import com.contribute.demo.repository.AccountRepository;
import com.contribute.demo.service.AccountService;
import com.contribute.demo.service.LoginMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : AccountServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/24
 **/
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    AccountRepository accountRepository;
    @Autowired
    LoginMessageService loginMessageService;


    @Override
    public Account findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Account editUserMessage(Usermessage msg) {
        Account account=loginMessageService.getLoginAccount();
        Account a=new Account();

        a.setId(account.getId());
        a.setIdentity(account.getIdentity());
        a.setUsername(account.getUsername());
        a.setPassword(account.getPassword());

        a.setUsermessage(msg);
        msg.setAccount(account);
        accountRepository.save(a);

        a.getUsermessage().setAccount(null);

        return a;
    }

    @Override
    public Account getAccount() {
        Integer id=loginMessageService.getLoginAccount().getId();
        return accountRepository.findAccountById(id);
}
}
