package com.sostraik1903.distroprofes_v3.entity;

public class UserRole {
    private UserVO userVO;
    private RoleVO roleVO;

    public UserRole() {
    }

    public UserRole(UserVO userVO, RoleVO roleVO) {
        this.userVO = userVO;
        this.roleVO = roleVO;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public RoleVO getRoleVO() {
        return roleVO;
    }

    public void setRoleVO(RoleVO roleVO) {
        this.roleVO = roleVO;
    }
}
