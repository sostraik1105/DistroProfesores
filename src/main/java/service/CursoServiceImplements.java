package service;

import entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CursoRepository;

import java.util.Collection;

@Service
public class CursoServiceImplements implements CursoService{
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional(readOnly = false)
    public void create(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer cursoId) {
        cursoRepository.deleteById(cursoId);
    }

    @Override
    public Curso findById(Integer cursoId) {
        return cursoRepository.findById(cursoId).orElse(null);
    }

    @Override
    public Collection<Curso> findAll() {
        return cursoRepository.findAll();
    }
}
