package com.contribute.demo.controller;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.pojo.Usermessage;
import com.contribute.demo.service.AccountService;
import com.contribute.demo.service.LoginMessageService;
import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response)throws IOException {
        return "login";
    }

    @RequestMapping(value ="/test", method = RequestMethod.GET)
    public String test(HttpServletResponse response)throws IOException {
        return "login";
    }

    /**
     * 用户修改个人资料
     */
    @RequestMapping(value = "/editusermsg",method = RequestMethod.POST)
    public Result editUserMessage(@RequestBody Usermessage msg){
        accountService.editUserMessage(msg);
        return new Result();
    }

    /**
     * 获取当前登录的Account
     * @return
     */
    @RequestMapping(value = "/getaccount",method = RequestMethod.GET)
    public Result getAccount(){
        Account account=loginMessageService.getLoginAccount();
        return new Result(true,"ok",account);
    }




//    @RequestMapping(path = "/send",method = RequestMethod.POST)
//    String sendMessage(@RequestParam("message") String message){
//        webSocketService.sendMessageToAllExpert(message);
//
//        return "发送成功";
//    }
}
