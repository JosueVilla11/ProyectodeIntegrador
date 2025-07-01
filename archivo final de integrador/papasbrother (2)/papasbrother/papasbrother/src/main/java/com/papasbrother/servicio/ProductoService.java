package com.papasbrother.servicio;

import com.papasbrother.modelo.Producto;
import com.papasbrother.repositorio.ProductoRepository;
import java.util.List;
import java.util.Optional;

public class ProductoService {
    private final ProductoRepository productoRepository = new ProductoRepository();

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}