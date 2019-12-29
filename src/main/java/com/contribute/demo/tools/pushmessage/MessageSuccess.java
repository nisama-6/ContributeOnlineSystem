package com.contribute.demo.tools.pushmessage;

import com.alibaba.fastjson.JSONObject;
import com.contribute.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @ClassName : SuccessMessage
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/28
 **/

public class MessageSuccess extends ResMessage {

    private final String type="success";

    public MessageSuccess(PushMethod pushMethod, String title, String message) {
        super(pushMethod, title, message);
    }

    @Override
    public void pushToOne(String id) {
        pushMethod.pushToOne(id,this.messageToJson());
    }

    @Override
    public void pushToAll() {
        pushMethod.pushToAll(this.messageToJson());
    }

    private String messageToJson(){
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("title",this.title);
        jsonObject.put("message",this.message);
        jsonObject.put("type",this.type);
        return jsonObject.toJSONString();
    }
}
