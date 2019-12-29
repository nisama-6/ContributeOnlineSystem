package com.contribute.demo.tools.pushmessage;

import com.contribute.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @ClassName : PushToUser
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/28
 **/

public class PushToUser implements PushMethod {

    private SimpMessagingTemplate template;
    private Logger logger= LoggerFactory.getLogger(DemoApplication.class);
    public PushToUser(SimpMessagingTemplate simpMessagingTemplate){
        this.template=simpMessagingTemplate;
    }
    @Override
    public void pushToOne(String id, String message) {
        template.convertAndSendToUser(id,"/message",message);
        logger.info("webscoket发送给普通用户信息------"+message);
    }

    @Override
    public void pushToAll(String message) {
        template.convertAndSend("/user/getResponse", message);
    }
}
