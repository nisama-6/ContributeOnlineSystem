package com.contribute.demo.tools;

/**
 * @ClassName : ResponseMessage
 * @Description : TODO 服务端往客户端推送消息的封装
 * @Author : niran
 * @Date : 2019/12/25
 **/

public class ResponseMessage {

    /**
     * 成功为true
     */
    private boolean ok;
    /**
     * 错误消息或其他提示
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public ResponseMessage() {
        this(true, "", "");
    }

    public ResponseMessage(Object data) {
        this(true, "", data);
    }

    public ResponseMessage(boolean ok, String msg) {
        this(ok, msg, "");
    }

    public ResponseMessage(boolean ok, String msg, Object data) {
        this.ok = ok;
        this.msg = msg;
        this.data = data;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
