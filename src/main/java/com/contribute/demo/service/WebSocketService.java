package com.contribute.demo.service;

import com.contribute.demo.tools.ResponseMessage;

/**
 * @ClassName : webSocketService
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/20
 **/

public interface WebSocketService {

    /**
     * 发送消息给指定ID
     * @param id 接收人ID
     * @param responseMessage 消息
     */
    void sendMessageByID(String id, ResponseMessage responseMessage);

    /**
     * 发送消息给所有专家
     * @param responseMessage 消息
     */
    void sendMessageToAllExpert(ResponseMessage responseMessage);
}
