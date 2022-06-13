package com.sostraik1903.distroprofes_v3.service;

import com.sostraik1903.distroprofes_v3.entity.Curso;

import java.util.Collection;

public interface CursoService {
    public abstract void create(Curso curso);
    public abstract void update(Curso curso);
    public abstract void delete(Integer cursoId);
    public abstract Curso findById(Integer cursoId);
    public abstract Collection<Curso> findAll();
}
