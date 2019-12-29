package com.contribute.demo.controller;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Usermessage;
import com.contribute.demo.repository.UsermessageRepository;
import com.contribute.demo.service.AccountService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : AccountController
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/20
 **/


@RestController
public class AccountController {

    @Autowired
    private WebSocketService webSocketService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private LoginMessageService loginMessageService;
    @Autowired
    private UsermessageRepository usermessageRepository;


    /**
     * 用户新增/修改个人资料
     */
    @RequestMapping(value = "/editusermsg", method = RequestMethod.POST)
    public Result editUserMessage(@RequestBody Usermessage msg) throws IOException, ServletException {
        Account account = accountService.editUserMessage(msg);

        return new Result(true, "新增修改成功", account);
    }

    @RequestMapping(value = "/checkusername",method = RequestMethod.GET)
    public Result checkUsername(String username){
        Boolean canregist=accountService.checkUsername(username);
        return new Result(canregist,"检查用户名是否可用",canregist);
    }

    /**
     * 注册新用户
     * @param username
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result regist(String username, String password1,String password2) {
        Account account = accountService.regist(username, password1,password2);
        return new Result(true, "注册",account);
    }

    /**
     * 更改密码
     * @return
     */
    @RequestMapping(value="/changepassword",method = RequestMethod.POST)
    public Result changePassword(String oldPassword,String newPassword1,String newPassword2) throws IOException, ServletException {
        String msg=accountService.changePassword(oldPassword,newPassword1,newPassword2);
        return new Result(msg.equals("修改结束"),msg);
    }

    /**
     * 获取当前登录的Account
     *
     * @return
     */
    @RequestMapping(value = "/getaccount", method = RequestMethod.GET)
    public Result getAccount() throws IOException, ServletException {

        Account account = loginMessageService.getLoginAccount();
        Account account1=accountService.findByUsername(account.getUsername());
        return new Result(true, "ok", account1);
    }

}
