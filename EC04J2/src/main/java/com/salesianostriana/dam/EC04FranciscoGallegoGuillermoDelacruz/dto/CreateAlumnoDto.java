package com.salesianostriana.dam.EC04FranciscoGallegoGuillermoDelacruz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAlumnoDto {

    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer telefono;
    private String email;
    private Long direccionId;
    private Long cursoId;

}
