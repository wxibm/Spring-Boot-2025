package com.example.demo.entity;

import com.google.gson.Gson;
import java.sql.Timestamp;

public class User {
    private Integer id;

    private String userName;

    private String password;

    private String userAvatar;

    private Timestamp createDate;

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

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

//    返回该对象的字符串表示
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
