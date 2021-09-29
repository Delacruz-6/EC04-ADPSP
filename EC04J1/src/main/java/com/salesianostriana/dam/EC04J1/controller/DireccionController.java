package com.salesianostriana.dam.EC04J1.controller;

import com.salesianostriana.dam.EC04J1.Direccion;
import com.salesianostriana.dam.EC04J1.DireccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class DireccionController {

    private final DireccionRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Direccion>> findAll() {

        return ResponseEntity
                .ok()
                .body(repository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> findOne(@PathVariable Long id) {

        return ResponseEntity
                .of(repository.findById(id));

    }


    @PostMapping("/")
    public ResponseEntity<Direccion> create(@RequestBody Direccion nueva) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(nueva));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> edit(
            @RequestBody Direccion e,
            @PathVariable Long id) {

        return ResponseEntity.of(
                repository.findById(id).map(d -> {
                    d.setTipoVia(d.getTipoVia());
                    d.setLinea1(d.getLinea1());
                    d.setLinea2(d.getLinea2());
                    d.setCp(d.getCp());
                    d.setPoblacion(d.getPoblacion());
                    d.setProvincia(d.getProvincia());
                    repository.save(d);
                    return d;
                })
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}

