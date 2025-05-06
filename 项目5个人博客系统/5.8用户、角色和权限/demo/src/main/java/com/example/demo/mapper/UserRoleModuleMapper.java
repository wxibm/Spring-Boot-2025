package com.example.demo.mapper;

import com.example.demo.entity.RoleModuleEntity;
import com.example.demo.entity.UserRoleEntity;
import com.example.demo.entity.UserRoleModuleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserRoleModuleMapper {
    UserRoleEntity selectRoleByUser(String userId);

    RoleModuleEntity selectModuleByRole(String roleId);

    UserRoleModuleEntity selectModuleByUser(String userId);
}
