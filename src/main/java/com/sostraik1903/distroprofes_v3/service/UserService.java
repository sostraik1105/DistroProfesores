package com.sostraik1903.distroprofes_v3.service;

import com.sostraik1903.distroprofes_v3.entity.UserVO;

import java.util.Collection;

public interface UserService {
    public abstract void create(UserVO user);

    public abstract void update(UserVO user);

    public abstract void delete(Integer userId);

    public abstract UserVO findById(Integer userId);

    public abstract Collection<UserVO> findAll();

    public abstract UserVO findByUsername(String username);

    public abstract Collection<Object[]> findAllWhitRole();
}
