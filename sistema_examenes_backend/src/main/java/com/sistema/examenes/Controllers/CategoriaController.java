package com.sistema.examenes.Controllers;

import com.sistema.examenes.Models.Categoria;
import com.sistema.examenes.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/")
    public ResponseEntity<Categoria> post_guardarCategoria(@RequestBody Categoria categoria){
        Categoria categoriaGuardada = categoriaService.agregarCategoria(categoria);
        return ResponseEntity.ok(categoriaGuardada);
    }

    @GetMapping("/{categoriaId}")
    public Categoria get_listarCategoriaId(@PathVariable("categoriaId") Long categoriaId){
        return categoriaService.obtenerCategoriaId(categoriaId);
    }

    @GetMapping("/")
    public ResponseEntity<?> get_listarCategorias(){
        return ResponseEntity.ok(categoriaService.obtenerCategorias());
    }

    @PutMapping("/")
    public Categoria put_actualizarCategoria(@RequestBody Categoria categoria){
        return categoriaService.actualizarCategoria(categoria);
    }

    @DeleteMapping("/{categoria_id}")
    public void del_eliminarCategoria(@PathVariable("categoria_id") Long categoria_id){
        categoriaService.eliminarCategoria(categoria_id);
    }
}

