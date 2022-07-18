package com.sostraik1903.distroprofes_v3.mapper;

import com.sostraik1903.distroprofes_v3.entity.UserRole;

public class userRoleMapper {
    private Integer idUser;
    private String username;
    private Integer idRole;
    private String role;

    public userRoleMapper() {
    }

    public userRoleMapper(Integer idUser, String username, Integer idRole, String role) {
        this.idUser = idUser;
        this.username = username;
        this.idRole = idRole;
        this.role = role;
    }

    public userRoleMapper(UserRole userRole){
        this(userRole.getUserVO().getUserId(),
                userRole.getUserVO().getUsername(),
                userRole.getRoleVO().getRoleId(),
                userRole.getRoleVO().getRole());
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


