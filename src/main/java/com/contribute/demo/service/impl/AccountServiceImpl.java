package com.contribute.demo.service.impl;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.repository.AccountRepository;
import com.contribute.demo.service.AccountService;
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


    @Override
    public Account findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
