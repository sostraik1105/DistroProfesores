package service;

import entity.Encargado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.EncargadoRepository;

import java.util.Collection;

@Service
public class EncargadoServiceImplements implements EncargadoService{
    @Autowired
    private EncargadoRepository encargadoRepository;

    @Override
    @Transactional(readOnly = false)
    public void create(Encargado encargado) {
        encargadoRepository.save(encargado);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Encargado encargado) {
        encargadoRepository.save(encargado);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer encargadoId) {
        encargadoRepository.deleteById(encargadoId);
    }

    @Override
    public Encargado findById(Integer encargadoId) {
        return encargadoRepository.findById(encargadoId).orElse(null);
    }

    @Override
    public Collection<Encargado> findAll() {
        return encargadoRepository.findAll();
    }
}
