package com.contribute.demo.tools.pushmessage;

public class MessageSuccessFactory  implements Factory {
    @Override
    public MessageSuccess createResMessage(PushMethod pushMethod, String title, String message) {
        return new MessageSuccess(pushMethod, title, message);
    }
}
