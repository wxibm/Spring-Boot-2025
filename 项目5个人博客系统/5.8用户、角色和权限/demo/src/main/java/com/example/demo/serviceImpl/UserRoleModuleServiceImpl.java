package com.example.demo.serviceImpl;

import com.example.demo.entity.RoleModuleEntity;
import com.example.demo.entity.UserRoleEntity;
import com.example.demo.entity.UserRoleModuleEntity;
import com.example.demo.mapper.UserRoleModuleMapper;
import com.example.demo.service.UserRoleModuleService;
import com.example.demo.utils.ReturnT;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserRoleModuleServiceImpl implements UserRoleModuleService {
    @Resource
    private UserRoleModuleMapper userRoleModuleMapper;

    public ReturnT<UserRoleEntity> selectRoleByUser(String userId) {
        try {
            return ReturnT.Success(userRoleModuleMapper.selectRoleByUser(userId));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<RoleModuleEntity> selectModuleByRole(String roleId) {
        try {
            return ReturnT.Success(userRoleModuleMapper.selectModuleByRole(roleId));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }

    public ReturnT<UserRoleModuleEntity> selectModuleByUser(String userId) {
        try {
//            System.out.println(userRoleModuleMapper.selectModuleByUser(userId).getModuleList());
            return ReturnT.Success(userRoleModuleMapper.selectModuleByUser(userId));
        } catch (Exception e) {
            return ReturnT.Failed(e.getMessage());
        }
    }
}
