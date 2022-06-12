package service;

import entity.Plana;

import java.util.Collection;

public interface PlanaService {
    public abstract void create(Plana plana);
    public abstract void update(Plana plana);
    public abstract void delete(Integer planaId);
    public abstract Plana findById(Integer planaId);
    public abstract Collection<Plana> findAll();
}
