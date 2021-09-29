package com.salesianostriana.dam.EC04FranciscoGallegoGuillermoDelacruz.dto;

import com.salesianostriana.dam.EC04FranciscoGallegoGuillermoDelacruz.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoDtoConverter {

    public Producto createProductoDtoToProducto(CreateProductoDto c) {
        return new Producto(
                c.getNombre(),
                c.getDesc(),
                c.getPvp(),
                c.getImagenes()
        );
    }

    public GetProductoDto productoToGetProductoDto(Producto a) {

        GetProductoDto result = new GetProductoDto();
        result.setNombre(a.getNombre());
        result.setPvp(a.getPvp());
        result.setImagenes(a.getImagenes());
        result.setCategoria(a.getCategoria().getNombre());
        return result;
    }

}