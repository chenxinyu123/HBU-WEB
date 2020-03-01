package com.how2java.springboot.entity;

public class SuccessCode implements Respone{
    private int code;
    private String message;
    private String json;

    public SuccessCode(int code, String message, String json) {
        this.code = code;
        this.message = message;
        this.json = json;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SuccessCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", json='" + json + '\'' +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
