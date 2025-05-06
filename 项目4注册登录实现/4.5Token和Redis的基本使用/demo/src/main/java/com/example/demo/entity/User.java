package com.example.demo.entity;

import com.google.gson.Gson;

public class User {
    private Integer id;
    private String userName;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    返回该对象的字符串表示
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
