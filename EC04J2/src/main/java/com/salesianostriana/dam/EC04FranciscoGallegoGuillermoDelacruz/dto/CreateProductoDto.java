package com.salesianostriana.dam.EC04FranciscoGallegoGuillermoDelacruz.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreateProductoDto {

    private String nombre;
    private String desc;
    private double pvp;
    private List<String> Imagenes;
    private Long categoriaId;

}




