package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.RoleVO;

public class RoleMapper {
    private Integer roleId;
    private String role;

    public RoleMapper() {
    }

    public RoleMapper(Integer roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public RoleMapper(RoleVO roleVO){
        this(roleVO.getRoleId(), roleVO.getRole());
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
