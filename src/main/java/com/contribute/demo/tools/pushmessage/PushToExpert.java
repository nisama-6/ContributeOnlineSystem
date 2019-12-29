package com.contribute.demo.tools.pushmessage;

import com.contribute.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @ClassName : PushToExpert
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/28
 **/

public class PushToExpert implements PushMethod {

    @Autowired
    public SimpMessagingTemplate template;
    private Logger logger= LoggerFactory.getLogger(DemoApplication.class);
    @Override
    public void pushToOne(String id, String message) {
        template.convertAndSendToUser(id,"/message",message);
        logger.info("webscoket发送信息------"+message);
    }

    @Override
    public void pushToAll(String message) {
        template.convertAndSend("/expert/getResponse", message);
        logger.info("webscoket发送给所有专家------"+message);
    }
}
