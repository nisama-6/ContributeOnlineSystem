package com.contribute.demo.controller;

import com.contribute.demo.pojo.Account;
import com.contribute.demo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response)throws IOException {
        return "login";
    }

    @RequestMapping(value ="/test", method = RequestMethod.GET)
    public String test(HttpServletResponse response)throws IOException {
        return "login";
    }

//    @RequestMapping(path = "/send",method = RequestMethod.POST)
//    String sendMessage(@RequestParam("message") String message){
//        webSocketService.sendMessageToAllExpert(message);
//
//        return "发送成功";
//    }
}
