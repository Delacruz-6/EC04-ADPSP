package com.salesianostriana.dam.EC04FranciscoGallegoGuillermoDelacruz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductoDto {

    private String nombre;
    private double pvp;
    private List<String> imagenes;
    private String categoria;


}
