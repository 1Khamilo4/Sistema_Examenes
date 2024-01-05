package com.sistema.examenes.Controllers;

import com.sistema.examenes.Models.Examen;
import com.sistema.examenes.Models.Pregunta;
import com.sistema.examenes.Services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("examenes/")
@CrossOrigin("http://localhost:4200")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<Examen> post_guardarExamen(@RequestBody Examen examen){
        Examen examenGuardado = examenService.agregarExamen(examen);
        return ResponseEntity.ok(examenGuardado);
    }

    @GetMapping("/{examenId}")
    public Examen get_listarExamenId(@PathVariable("examenId") Long examenId){
        return examenService.obtenerExamen(examenId);
    }

    @GetMapping("/")
    public ResponseEntity<?> get_listarExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }

    @PutMapping("/")
    public ResponseEntity<Examen> put_actualizarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }

    @DeleteMapping("/{id_examen}")
    public void del_eliminarExamen(@PathVariable("id_examen") Long id_examen ){
          examenService.eliminarExamen(id_examen);
    }
}
