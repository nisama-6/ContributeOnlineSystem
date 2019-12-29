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
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import java.io.IOException;

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
    public Account findByUsername(String username)
    {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Account editUserMessage(Usermessage msg) throws IOException, ServletException {
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
    public String changePassword(String oldpassword, String password1, String password2) throws IOException, ServletException {

        Account oldaccount = loginMessageService.getLoginAccount();
        if (oldaccount.getPassword().equals(DigestUtils.md5DigestAsHex(oldpassword.getBytes()))) {
            if (password1.equals(password2)) {
                accountRepository.changepassword(DigestUtils.md5DigestAsHex(password1.getBytes()),oldaccount.getId());
                return "修改结束";
            } else {
                return "输入的两次新密码不相等";
            }
        } else {
            return "旧密码不正确";
        }
    }

    @Override
    public Account regist(String username, String password1, String password2) {
        if (password1.equals(password2) || accountRepository.countByUsername(username) == 0) {
            Account account = new Account(username, DigestUtils.md5DigestAsHex(password1.getBytes()), "user");//用户的identity为user
            Usermessage usermessage=new Usermessage();
            usermessage.setExp(0);
            usermessage.setLevel(1);
            usermessage.setAdv_url("http://download.niran.vip/moren/fb9431a4c99691e54952d85ed034faf9a6b7e4f22d45-xy5FHF_fw658.jpeg?imageView2/1/w/200/h/200/q/75|imageslim");
            return accountRepository.save(account);
        } else
            return null;
    }


}
