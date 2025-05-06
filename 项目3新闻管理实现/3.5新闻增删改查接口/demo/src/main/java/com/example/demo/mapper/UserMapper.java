package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> selectAllUsers();

    List<User> selectUsersByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<User> selectBySearch(@Param("condition") String condition, @Param("content") String content);

    int selectUsersCount();

    User selectByPrimaryKey(@Param("id") Integer id);

    int insertUser(User user);

    int deleteUser(@Param("id") int id);

    int updateUser(User user);

    int patchUser(User user);
}
