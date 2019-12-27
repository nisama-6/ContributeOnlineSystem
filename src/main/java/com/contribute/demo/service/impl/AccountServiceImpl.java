package com.contribute.demo.service.impl;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Usermessage;
import com.contribute.demo.repository.AccountRepository;
import com.contribute.demo.service.AccountService;
import com.contribute.demo.service.LoginMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Account account = loginMessageService.getLoginAccount();
        Account a = new Account();

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

    public Boolean checkUsername(String username) {
        if (accountRepository.countByUsername(username) > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String changePassword(String oldpassword, String password1, String password2) {

        Account oldaccount = loginMessageService.getLoginAccount();
        if (oldaccount.getPassword().equals(oldpassword)) {
            if (password1.equals(password2)) {
                Account account = new Account(oldaccount.getUsername(), password1, "user");
                account.setId(oldaccount.getId());
                accountRepository.save(account);
                return "修改结束";
            } else {
                System.out.println("输入的两次新密码不相等");
                return "输入的两次新密码不相等";
            }
        } else {
            System.out.println("旧密码不正确！");
            return "旧密码不正确";
        }
    }

    @Override
    public Account regist(String username, String password1, String password2) {


        if (password1.equals(password2) || accountRepository.countByUsername(username) == 0) {
            Account account = new Account(username, password1, "user");//用户的identity为user
            return accountRepository.save(account);
        } else
            return null;
    }


}
