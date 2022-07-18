package com.sostraik1903.distroprofes_v3.service;

import com.sostraik1903.distroprofes_v3.entity.RoleVO;

import java.util.Collection;

public interface RolService {
    public abstract void create(RoleVO role);

    public abstract void update(RoleVO role);

    public abstract void delete(Integer roleId);

    public abstract RoleVO findById(Integer roleId);

    public abstract Collection<RoleVO> findAll();

}
