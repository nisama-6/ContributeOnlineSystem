package com.contribute.demo.service.impl;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.service.AccountService;
import com.contribute.demo.service.LoginMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @ClassName : LoginMsgServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/25
 **/

@Service
public class LoginMsgServiceImpl implements LoginMessageService {

    @Autowired
    AccountService accountService;

    @Override
    public Account getLoginAccount() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account=new Account();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            account=accountService.findByUsername(username);
        }
        return account;
    }
}
