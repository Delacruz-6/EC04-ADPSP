package com.salesianostriana.dam.EC04J1.controller;

import com.salesianostriana.dam.EC04J1.*;
import com.salesianostriana.dam.EC04J1.dto.AlumnoDtoConverter;
import com.salesianostriana.dam.EC04J1.dto.CreateAlumnoDto;
import com.salesianostriana.dam.EC04J1.dto.GetAlumnoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoRepository repository;

    private final AlumnoDtoConverter dtoConverter;

    private final CursoRepository cursoRepository;

    private final DireccionRepository direccionRepository;

    @GetMapping("/")
    public ResponseEntity<List<GetAlumnoDto>> findAll() {

        List<Alumno> data = repository.findAll();

        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<GetAlumnoDto> result =
                    data.stream()
                            .map(dtoConverter::alumnoToGetAlumnoDto)
                            .collect(Collectors.toList());

            return ResponseEntity
                    .ok()
                    .body(result);

        }



    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> findOne(@PathVariable Long id) {

        return ResponseEntity
                .of(repository.findById(id));

    }


    @PostMapping("/")
    public ResponseEntity<Alumno> create(@RequestBody CreateAlumnoDto dto) {

        if ((dto.getCursoId() == null)|| (dto.getDireccionId() == null )) {
            return ResponseEntity.badRequest().build();
        }


        Alumno nuevo = dtoConverter.createAlumnoDtoToAlumno(dto);

        Curso curso = cursoRepository.findById(dto.getCursoId()).orElse(null);

        nuevo.setCurso(curso);

        Direccion direccion = direccionRepository.findById(dto.getDireccionId()).orElse(null);


        nuevo.setDireccion(direccion);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(repository.save(nuevo));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> edit(
            @RequestBody Alumno e,
            @PathVariable Long id) {


        return ResponseEntity.of(
                repository.findById(id).map(a -> {
                    a.setNombre(e.getNombre());
                    a.setApellido1(e.getApellido1());
                    a.setApellido2(e.getApellido2());
                    a.setTelefono(e.getTelefono());
                    repository.save(a);
                    return a;
                })
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
