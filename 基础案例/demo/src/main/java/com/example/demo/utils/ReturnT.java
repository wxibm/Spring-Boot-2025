package com.example.demo.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ReturnT<T> implements Serializable {

    private static final long serialVersionUID = 2460338858989512546L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 相关数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String toString() {
        return "ReturnT(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }

    /**
     * 构造器 自定义响应码与提示信息
     * @param code 响应码
     * @param msg 提示信息
     */
    private ReturnT(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造器 自定义响应码、提示信息、数据
     * @param code 响应码
     * @param msg 提示信息
     * @param data 返回数据
     */
    private ReturnT(int code,String msg,T data){
        this(code,msg);
        this.data = data;
    }

    /**
     * 成功构造器  无返回数据
     */
    public static <T> ReturnT<T> Success(){
        return new ReturnT<>(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMsg());
    }

    /**
     * 成功构造器 自定义提示信息 无返回数据
     * @param msg 提示信息
     */
    public static <T> ReturnT<T> Success(String msg){
        return new ReturnT<>(ReturnCode.SUCCESS.getCode(), msg);
    }

    /**
     * 成功构造器  有返回数据
     */
    public static <T> ReturnT<T> Success(T data){
        return new ReturnT<>(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMsg(),data);
    }

    /**
     * 失败构造器  无返回数据
     */
    public static <T> ReturnT<T> Failed(){
        return new ReturnT<>(ReturnCode.FAILED.getCode(), ReturnCode.FAILED.getMsg());
    }

    /**
     * 失败构造器 自定义提示信息 无返回数据
     * @param msg 提示信息
     */
    public static <T> ReturnT<T> Failed(String msg){
        return new ReturnT<>(ReturnCode.FAILED.getCode(), msg);
    }

    /**
     * 失败构造器  有返回数据
     */
    public static <T> ReturnT<T> Failed(T data){
        return new ReturnT<>(ReturnCode.FAILED.getCode(), ReturnCode.FAILED.getMsg(),data);
    }
}