package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.sql.Timestamp;

public class User {
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}", message = "密码必须包含大小写、数字、特殊字符，并且长度至少为8")
    private String password;

    private String userAvatar;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat只是做格式化，无法做格式校验。如需对Timestamp进行验证，需要自定义注解。
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
