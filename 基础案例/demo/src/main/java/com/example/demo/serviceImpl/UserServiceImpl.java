package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.lang.Integer.parseInt;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /*AAAAAAAAAAAAAAAAAAAA*/
//    这里的方法名可以不和mapper里的一致，保持一致为了方便阅读
    public ReturnT<List<User>> selectAllUsers() {
        try {
            return ReturnT.Success(userMapper.selectAllUsers());
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    /*BBBBBBBBBBBBBBBBBBBB*/
    public ReturnT<List<User>> findAllWithPagination(String pageNum, String pageSize) {
        try {
            int offset = (parseInt(pageNum) - 1) * parseInt(pageSize);
            //将字符串强制转换成整数，出错则说明非整数
            return ReturnT.Success(userMapper.selectUsersByLimit(offset, parseInt(pageSize)));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    /*CCCCCCCCCCCCCCCCCCCC*/
    public ReturnT<List<User>> selectBySearch(String condition, String content) {
        try {
            return ReturnT.Success(userMapper.selectBySearch(condition, content));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    /*DDDDDDDDDDDDDDDDDDDD*/
    public int selectUsersCount() {
        return userMapper.selectUsersCount();
    }

    /*EEEEEEEEEEEEEEEEEEEE*/
    public ReturnT<User> selectByPrimaryKey(String id) {
        try {
            User user = userMapper.selectByPrimaryKey(parseInt(id));
            if (user == null)
                return ReturnT.Success("不存在此用户");
            System.out.println(user);
            return ReturnT.Success(user);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    /*FFFFFFFFFFFFFFFFFFFF*/
    public ReturnT<User> insertUser(User user) {
        try {
            userMapper.insertUser(user);
            return ReturnT.Success(user);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    /*GGGGGGGGGGGGGGGGGGGG*/
    public ReturnT<User> deleteUser(String id) {
        try {
            userMapper.deleteUser(parseInt(id));
            return ReturnT.Success();
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    /*HHHHHHHHHHHHHHHHHHHH*/
    public ReturnT<User> updateUser(User user) {
        try {
            userMapper.updateUser(user);
            return ReturnT.Success(user);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    /*IIIIIIIIIIIIIIIIIIII*/
    public ReturnT<User> patchUser(User user) {
        try {
            userMapper.patchUser(user);
            return ReturnT.Success(user);
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}