package com.sistema.examenes.Services.Impl;

import com.sistema.examenes.Models.Categoria;
import com.sistema.examenes.Repositories.CategoriaRepository;
import com.sistema.examenes.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Set<Categoria> obtenerCategorias() {
        return new LinkedHashSet<> (categoriaRepository.findAll());
    }

    @Override
    public Categoria obtenerCategoriaId(Long categoria_id) {
        return categoriaRepository.findById(categoria_id).get();

    }

    @Override
    public void eliminarCategoria(Long categoria_id) {
        Categoria categoria = new Categoria();

        categoria.setCategoriaId(categoria_id);

        categoriaRepository.delete(categoria);
    }
}
