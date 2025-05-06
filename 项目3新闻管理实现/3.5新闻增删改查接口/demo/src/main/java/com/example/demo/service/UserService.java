package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.ReturnT;
import java.util.List;

public interface UserService {
    public ReturnT<List<User>> selectAllUsers();

    public ReturnT<List<User>> findAllWithPagination(String pageNum, String pageSize);

    public ReturnT<List<User>> selectBySearch(String condition, String content);

    public int selectUsersCount();

    public ReturnT<User> selectByPrimaryKey(String id);

    public ReturnT<User> insertUser(User user);

    public ReturnT<User> deleteUser(String id);

    public ReturnT<User> updateUser(User user);

    public ReturnT<User> patchUser(User user);
}
