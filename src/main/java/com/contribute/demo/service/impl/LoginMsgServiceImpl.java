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
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.HashMap;
import java.util.Map;

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

    public static Map<String,Account> accountMap=new HashMap<>();

    @Override
    public Account getLoginAccount() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account=new Account();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            account=accountMap.get(username);
        }
        return account;
    }

    public static void put(String username, Account account){
        accountMap.put(username,account);
    }

    public static void remove(String username){
        accountMap.remove(username);
    }
}
