package com.contribute.demo.controller;

import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : CheckCenterController
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/11/12
 **/

@RestController
@RequestMapping("/api")
public class CheckCenterController {

    @Autowired
    public SimpMessagingTemplate template;

    @Autowired
    WebSocketService webSocketService;
    @GetMapping("/subscribe/{msg}")
    public String subscribe(@PathVariable("msg") String rm) {
        ResponseMessage responseMessage=new ResponseMessage("恭喜","您的稿件已通过审核！",ResponseMessage.SUCCESS);
        //广播使用convertAndSend方法，第一个参数为目的地，和js中订阅的目的地要一致
        webSocketService.sendMessageByID("1236",responseMessage);
        return "12";
    }

    @GetMapping("/p2p/{id}/{msg}")
    public void queuw(@PathVariable("msg") String rm, @PathVariable("id") String id) {
        System.out.println("进入方法");
        template.convertAndSendToUser(id,"/message",rm);
    }
}
