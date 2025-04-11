package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /*AAAAAAAAAAAAAAAAAAAA*/
    List<User> selectAllUsers();//需要和UserMapping.xml文件中的id保持一致


    /*BBBBBBBBBBBBBBBBBBBB*/
    List<User> selectUsersByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /*CCCCCCCCCCCCCCCCCCCC*/
    List<User> selectBySearch(@Param("condition") String condition, @Param("content") String content);

    /*DDDDDDDDDDDDDDDDDDDD*/
    int selectUsersCount();

    /*EEEEEEEEEEEEEEEEEEEE*/
    User selectByPrimaryKey(@Param("id") Integer id);

    /*FFFFFFFFFFFFFFFFFFFF*/
    int insertUser(User user);

    /*GGGGGGGGGGGGGGGGGGGG*/
    int deleteUser(@Param("id") int id);

    /*HHHHHHHHHHHHHHHHHHHH*/
    int updateUser(User user);

    /*IIIIIIIIIIIIIIIIIIII*/
    int patchUser(User user);
}
