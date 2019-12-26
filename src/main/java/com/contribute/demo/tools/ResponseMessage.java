package com.contribute.demo.tools;

/**
 * @ClassName : ResponseMessage
 * @Description : TODO 服务端往客户端推送消息的封装
 * @Author : niran
 * @Date : 2019/12/25
 **/

public class ResponseMessage {

    public static String SUCCESS="success";
    public static String DANGER="danger";
    public static String WARNING="warning";
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知信息主体
     */
    private String message;
    /**
     * 通知类型
     */
    private String type;

    public ResponseMessage(String title, String message, String type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
