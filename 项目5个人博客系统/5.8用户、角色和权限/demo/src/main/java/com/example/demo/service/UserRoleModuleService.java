package com.example.demo.service;

import com.example.demo.entity.RoleModuleEntity;
import com.example.demo.entity.UserRoleEntity;
import com.example.demo.entity.UserRoleModuleEntity;
import com.example.demo.utils.ReturnT;

public interface UserRoleModuleService {
    public ReturnT<UserRoleEntity> selectRoleByUser(String userId);

    public ReturnT<RoleModuleEntity> selectModuleByRole(String roleId);

    public ReturnT<UserRoleModuleEntity> selectModuleByUser(String userId);
}
