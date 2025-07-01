package com.papasbrother.repositorio;

import com.papasbrother.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private final List<Producto> productos = new ArrayList<>();

    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }

    public Optional<Producto> findById(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Producto save(Producto producto) {
        productos.add(producto);
        return producto;
    }

    public void deleteById(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}