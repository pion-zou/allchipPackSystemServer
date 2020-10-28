package com.allchip.pack.bean;

public class RequestBean<T> {

    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_FAILED = 0;
    public static final int TOKEN_INVALID = -1;

    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
