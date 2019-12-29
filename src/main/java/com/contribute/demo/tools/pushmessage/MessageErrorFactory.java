package com.contribute.demo.tools.pushmessage;

public class MessageErrorFactory implements Factory {
    @Override
    public MessageError createResMessage(PushMethod pushMethod, String title, String message) {
        return new MessageError(pushMethod, title, message);
    }
}
