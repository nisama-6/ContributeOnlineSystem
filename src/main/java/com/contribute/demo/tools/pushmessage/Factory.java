package com.contribute.demo.tools.pushmessage;

public interface Factory {
    public ResMessage createResMessage(PushMethod pushMethod, String title, String message);
}
