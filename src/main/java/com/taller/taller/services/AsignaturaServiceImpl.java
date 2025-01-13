package com.taller.taller.services;

import com.taller.taller.entities.Asignatura;
import com.taller.taller.respositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> findAll() {
        return (List<Asignatura>) asignaturaRepository.findAll();
    }

    @Override
    public Optional<Asignatura> findById(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void deleteById(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
