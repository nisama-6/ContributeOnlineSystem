package com.contribute.demo.controller;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    String login(@RequestParam("username") String username,@RequestParam("password") String password){
        Account account =new Account();
        account.setId(Integer.valueOf(username));
        account.setIdentity("expert");

        return "登陆成功";
    }
    @RequestMapping(path = "/send",method = RequestMethod.POST)
    String sendMessage(@RequestParam("message") String message){
        webSocketService.sendMessageToAllExpert(message);

        return "发送成功";
    }
}
