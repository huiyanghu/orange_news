package com.it7890.orange.manage.vo;

/**
 * @author gg
 * @create 2017/6/19
 **/
public class ResponseBase {
    private int success;
    private String msg;
    private int status;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
