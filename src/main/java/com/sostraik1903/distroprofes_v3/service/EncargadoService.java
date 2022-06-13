package com.sostraik1903.distroprofes_v3.service;

import com.sostraik1903.distroprofes_v3.entity.Encargado;

import java.util.Collection;

public interface EncargadoService {
    public abstract void create(Encargado encargado);
    public abstract void update(Encargado encargado);
    public abstract void delete(Integer encargadoId);
    public abstract Encargado findById(Integer encargadoId);
    public abstract Collection<Encargado> findAll();
}
