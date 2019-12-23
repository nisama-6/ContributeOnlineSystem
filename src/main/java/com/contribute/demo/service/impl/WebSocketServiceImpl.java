package com.contribute.demo.service.impl;

import com.contribute.demo.service.WebSocketService;
import com.contribute.demo.tools.WebSocketServer;
import org.springframework.stereotype.Service;

/**
 * @ClassName : webSocketServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/20
 **/

@Service
public class WebSocketServiceImpl implements WebSocketService {
    @Override
    public void sendMessageByID(Integer id, String message) {
        WebSocketServer.sendInfo(message,id);
    }

    @Override
    public void sendMessageToAllExpert(String message) {
        WebSocketServer.sendInfoToExperts(message);
    }
}
