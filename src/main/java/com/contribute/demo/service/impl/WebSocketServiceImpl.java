package com.contribute.demo.service.impl;

import com.contribute.demo.DemoApplication;
import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.ResponseMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName : webSocketServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/20
 **/

@Service
public class WebSocketServiceImpl implements WebSocketService {


    @Autowired
    public SimpMessagingTemplate template;
    private Logger logger= LoggerFactory.getLogger(DemoApplication.class);

    @Override
    public void sendMessageByID(String id, ResponseMessage responseMessage) {
        template.convertAndSendToUser(id,"/message",responseMessage);
        logger.info("webscoket发送信息------"+responseMessage.getMessage());
    }

    @Override
    public void sendMessageToAllExpert(ResponseMessage responseMessage) {
        template.convertAndSend("/expert/getResponse", responseMessage);
    }
}
