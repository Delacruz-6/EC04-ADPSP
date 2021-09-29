package com.salesianostriana.dam.EC04FranciscoGallegoGuillermoDelacruz;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy="categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto p) {
        p.setCategoria(this);
        this.productos.add(p);
    }

    public void removeProducto(Producto p) {
        this.productos.remove(p);
        p.setCategoria(null);
    }
}
