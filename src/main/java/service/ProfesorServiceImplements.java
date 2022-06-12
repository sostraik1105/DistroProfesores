package service;

import entity.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProfesorRepository;

import java.util.Collection;

@Service
public class ProfesorServiceImplements implements ProfesorService{
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    @Transactional(readOnly = false)
    public void create(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer profesorId) {
        profesorRepository.deleteById(profesorId);
    }

    @Override
    public Profesor findById(Integer profesorId) {
        return profesorRepository.findById(profesorId).orElse(null);
    }

    @Override
    public Collection<Profesor> findAll() {
        return profesorRepository.findAll();
    }
}
