package com.contribute.demo.tools.pushmessage;

/**
 * @ClassName : PushMethod
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/28
 **/

public interface PushMethod {
    /**
     * 点对点推送
     * @param id 接收者id
     * @param message 消息主体
     */
    void pushToOne(String id,String message);

    /**
     * 广播推送
     * @param message 消息主体
     */
    void pushToAll(String message);
}
