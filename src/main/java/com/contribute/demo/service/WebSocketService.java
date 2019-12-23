package com.contribute.demo.service;

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
     * @param message 消息
     */
    void sendMessageByID(Integer id,String message);

    /**
     * 发送消息给所有专家
     * @param message 消息
     */
    void sendMessageToAllExpert(String message);
}
