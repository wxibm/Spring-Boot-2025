package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.ReturnT;
import java.util.List;

public interface UserService {
    /*AAAAAAAAAAAAAAAAAAAA*/
    public ReturnT<List<User>> selectAllUsers();

    /*BBBBBBBBBBBBBBBBBBBB*/
    public ReturnT<List<User>> findAllWithPagination(String pageNum, String pageSize);

    /*CCCCCCCCCCCCCCCCCCCC*/
    public ReturnT<List<User>> selectBySearch(String condition, String content);

    /*DDDDDDDDDDDDDDDDDDDD*/
    public int selectUsersCount();

    /*EEEEEEEEEEEEEEEEEEEE*/
    public ReturnT<User> selectByPrimaryKey(String id);

    /*FFFFFFFFFFFFFFFFFFFF*/
    public ReturnT<User> insertUser(User user);

    /*GGGGGGGGGGGGGGGGGGGG*/
    public ReturnT<User> deleteUser(String id);

    /*HHHHHHHHHHHHHHHHHHHH*/
    public ReturnT<User> updateUser(User user);

    /*IIIIIIIIIIIIIIIIIIII*/
    public ReturnT<User> patchUser(User user);
}
