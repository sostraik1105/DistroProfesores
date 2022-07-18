package com.sostraik1903.distroprofes_v3.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(unique = true, nullable = false)
    private String role;

    @ManyToMany(mappedBy = "itemsRole")
    private Set<UserVO> itemsUser = new HashSet<>();

    public RoleVO() {
    }

    public RoleVO(Integer roleId, String role) {
        this.roleId = roleId;
        this.role = role;
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

    public Set<UserVO> getItemsUser() {
        return itemsUser;
    }

    public void setItemsUser(Set<UserVO> itemsUser) {
        this.itemsUser = itemsUser;
    }
}

