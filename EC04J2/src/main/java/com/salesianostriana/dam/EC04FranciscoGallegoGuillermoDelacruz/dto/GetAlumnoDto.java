package com.salesianostriana.dam.EC04FranciscoGallegoGuillermoDelacruz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAlumnoDto {

    private String nombre;
    private String apellidos;
    private String email;
    private String curso;
    private String direccion;
}
