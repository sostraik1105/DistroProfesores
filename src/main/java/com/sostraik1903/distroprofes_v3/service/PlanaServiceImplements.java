package com.sostraik1903.distroprofes_v3.service;

import com.sostraik1903.distroprofes_v3.entity.Plana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sostraik1903.distroprofes_v3.repository.PlanaRepository;

import java.util.Collection;

@Service
public class PlanaServiceImplements implements PlanaService{
    @Autowired
    private PlanaRepository planaRepository;

    @Override
    @Transactional(readOnly = false)
    public void create(Plana plana) {
        planaRepository.save(plana);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Plana plana) {
        planaRepository.save(plana);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer planaId) {
        planaRepository.deleteById(planaId);
    }

    @Override
    public Plana findById(Integer planaId) {
        return planaRepository.findById(planaId).orElse(null);
    }

    @Override
    public Collection<Plana> findAll() {
        return planaRepository.findAll();
    }
}
