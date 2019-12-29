package com.contribute.demo.tools.pushmessage;

/**
 * @ClassName : ResMessage
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/28
 **/

public abstract class ResMessage {
    protected PushMethod pushMethod;
    protected String title;
    protected String message;

    protected ResMessage(PushMethod pushMethod, String title, String message) {
        this.pushMethod = pushMethod;
        this.title = title;
        this.message = message;
    }

    public abstract void pushToOne(String id);
    public abstract void pushToAll();

}
