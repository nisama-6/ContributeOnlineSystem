package com.contribute.demo.tools.pushmessage;

public class MessageWarningFactory implements Factory {
    @Override
    public MessageWarning createResMessage(PushMethod pushMethod, String title, String message) {
        return new MessageWarning(pushMethod, title, message);
    }
}
