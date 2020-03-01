package com.how2java.springboot.entity;

public class ErrorCode implements Respone{
    private int Code;
    private String message;

    @Override
    public String toString() {
        return "ErrorCode{" +
                "Code=" + Code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode(int code, String message) {
        Code = code;
        this.message = message;
    }
}
