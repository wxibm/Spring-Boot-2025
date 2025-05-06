package com.example.demo.entity;

import java.util.List;

public class UserRoleModuleEntity {
    private String userId;

    private List<Module> moduleList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }
}
