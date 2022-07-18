package com.sostraik1903.distroprofes_v3.service;

import com.sostraik1903.distroprofes_v3.entity.RoleVO;
import com.sostraik1903.distroprofes_v3.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RolService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void create(RoleVO role) {
        roleRepository.save(role);
    }

    @Override
    public void update(RoleVO role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Integer roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public RoleVO findById(Integer roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public Collection<RoleVO> findAll() {
        return roleRepository.findAll();
    }
}
