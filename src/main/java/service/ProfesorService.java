package service;

import entity.Profesor;

import java.util.Collection;

public interface ProfesorService {
    public abstract void create(Profesor profesor);
    public abstract void update(Profesor profesor);
    public abstract void delete(Integer profesorId);
    public abstract Profesor findById(Integer profesorId);
    public abstract Collection<Profesor> findAll();
}
