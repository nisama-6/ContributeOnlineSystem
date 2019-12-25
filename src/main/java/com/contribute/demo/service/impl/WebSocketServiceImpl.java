package com.contribute.demo.service.impl;

import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.ResponseMessage;
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

    @Override
    public void sendMessageByID(Integer id, ResponseMessage responseMessage) {
        template.convertAndSendToUser(String.valueOf(id),"/message",responseMessage);
    }

    @Override
    public void sendMessageToAllExpert(ResponseMessage responseMessage) {
        template.convertAndSend("/expert/getResponse", responseMessage);
    }
}
