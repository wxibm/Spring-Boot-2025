package com.example.demo.service;

public interface UserService {
    public Object login(String userName, String password);

    public String createToken(Object object);

    public String getToken(String keyToken);

    public boolean deleteToken(String keyToken);
}
