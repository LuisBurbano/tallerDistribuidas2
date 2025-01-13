package com.taller.taller.controllers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.taller.taller.entities.Asignatura;
import com.taller.taller.services.AsignaturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignturaController {

    @Autowired
    AsignaturaService asignaturaService;

    @PostMapping
    public ResponseEntity<?> crear(@Validated @RequestBody Asignatura asignatura) {

        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.save(asignatura));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(asignaturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Asignatura> estudianteOptional = asignaturaService.findById(id);
        if (estudianteOptional.isPresent()) {
            return ResponseEntity.ok(estudianteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Asignatura estudiante, @PathVariable Long id) {
        Optional<Asignatura> asignaturaOptional = asignaturaService.findById(id);

        if (asignaturaOptional.isPresent()) {
            Asignatura asignaturaDB = asignaturaOptional.get();
            asignaturaDB.setNombre(estudiante.getNombre());
            asignaturaDB.setCodigo(estudiante.getCodigo());
            asignaturaDB.setCreditos(estudiante.getCreditos());
            asignaturaDB.setFecha(estudiante.getFecha());

            return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.save(asignaturaDB));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Asignatura> asignaturaOptional = asignaturaService.findById(id);

        if (asignaturaOptional.isPresent()) {
            asignaturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }


}
