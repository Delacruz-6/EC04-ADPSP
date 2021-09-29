package com.salesianostriana.dam.EC04J1.controller;

import com.salesianostriana.dam.EC04J1.Curso;
import com.salesianostriana.dam.EC04J1.CursoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CursoController {

    private final CursoRepository repository;

    public CursoController(CursoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Curso>> findAll() {

        return ResponseEntity
                .ok()
                .body(repository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findOne(@PathVariable Long id) {

        return ResponseEntity
                .of(repository.findById(id));

    }


    @PostMapping("/")
    public ResponseEntity<Curso> create(@RequestBody Curso nueva) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(nueva));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> edit(
            @RequestBody Curso e,
            @PathVariable Long id) {

        return ResponseEntity.of(
                repository.findById(id).map(c -> {
                    c.setNombre(e.getNombre());
                    repository.save(c);
                    return c;
                })
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
