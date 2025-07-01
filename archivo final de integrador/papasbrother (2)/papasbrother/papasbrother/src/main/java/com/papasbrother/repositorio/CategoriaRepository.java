package com.papasbrother.repositorio;


import com.papasbrother.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();

    public List<Categoria> findAll() {
        return new ArrayList<>(categorias);
    }

    public Optional<Categoria> findById(Long id) {
        return categorias.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Categoria save(Categoria categoria) {
        categorias.add(categoria);
        return categoria;
    }

    public void deleteById(Long id) {
        categorias.removeIf(c -> c.getId().equals(id));
    }
}