package com.example.demo.entity;

import java.util.List;

public class RoleModuleEntity {
    private String roleId;

    private List<Module> moduleList;

    private List<RoleModule> roleModuleList;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public List<RoleModule> getRoleModuleList() {
        return roleModuleList;
    }

    public void setRoleModuleList(List<RoleModule> roleModuleList) {
        this.roleModuleList = roleModuleList;
    }
}
