package com.sistema.examenes.Services;

import com.sistema.examenes.Models.Categoria;

import java.util.Set;

public interface CategoriaService {

    Categoria agregarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria);
    Set<Categoria> obtenerCategorias();
    Categoria obtenerCategoriaId(Long categoria_id);
    void eliminarCategoria(Long categoria_id);

}
