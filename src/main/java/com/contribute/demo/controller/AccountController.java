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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response) throws IOException {
        return "login";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletResponse response) throws IOException {
        return "login";
    }

    /**
     * 用户新增/修改个人资料
     */
    @RequestMapping(value = "/editusermsg", method = RequestMethod.POST)
    public Result editUserMessage(@RequestBody Usermessage msg) {
        Account account = accountService.editUserMessage(msg);

        return new Result(true, "新增 修改成功", account);
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
     * @param oldpassword
     * @param password1
     * @param password2
     * @return
     */
    @RequestMapping(value="/changepassword",method = RequestMethod.POST)
    public Result changePassword(String oldpassword,String password1,String password2){
        String msg=accountService.changePassword(oldpassword,password1,password2);
        return new Result(true,msg);
    }

    /**
     * 获取当前登录的Account
     *
     * @return
     */
    @RequestMapping(value = "/getaccount", method = RequestMethod.GET)
    public Result getAccount() {
        Account account = loginMessageService.getLoginAccount();
        return new Result(true, "ok", account);
    }


//    @RequestMapping(path = "/send",method = RequestMethod.POST)
//    String sendMessage(@RequestParam("message") String message){
//        webSocketService.sendMessageToAllExpert(message);
//
//        return "发送成功";
//    }
}
