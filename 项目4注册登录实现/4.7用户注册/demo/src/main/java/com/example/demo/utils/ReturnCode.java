package com.example.demo.utils;

public enum ReturnCode {

    SUCCESS(200,"操作成功"),
    FAILED(500, "操作失败"),
    USERNAME_EXISTS(209 , "用户名已经存在"),
    FORMAT_ERROR(400 , "格式不正确");

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
