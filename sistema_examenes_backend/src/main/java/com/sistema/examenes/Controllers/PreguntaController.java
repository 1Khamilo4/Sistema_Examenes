package com.sistema.examenes.Controllers;

import com.sistema.examenes.Models.Categoria;
import com.sistema.examenes.Models.Examen;
import com.sistema.examenes.Models.Pregunta;
import com.sistema.examenes.Services.ExamenService;
import com.sistema.examenes.Services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin("*")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;
    @Autowired
    private ExamenService examenService;

    @PostMapping("/")
    public ResponseEntity<Pregunta> post_guardarPregunta(@RequestBody Pregunta pregunta){
        Pregunta preguntaGuardada = preguntaService.agregarPregunta(pregunta);
        return ResponseEntity.ok(preguntaGuardada);
    }

    @GetMapping("/{preguntaId}")
    public Pregunta get_listarPreguntaId(@PathVariable("preguntaId") Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);
    }

    @GetMapping("/")
    public ResponseEntity<?> get_listarPreguntas(){
        return ResponseEntity.ok(preguntaService.obtenerPreguntas());
    }

    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> listarPreguntasDelExamen(@PathVariable("examenId") Long examenId){
        Examen examen = examenService.obtenerExamen(examenId);//2

        Set<Pregunta> preguntas =  examen.getPreguntas();

        List examenes = new ArrayList(preguntas);

        if(examenes.size() > Integer.parseInt(examen.getNumeroDePreguntas())){
            examenes = examenes.subList(0, Integer.parseInt(examen.getNumeroDePreguntas() + 1));
        }
        Collections.shuffle(examenes);

        return ResponseEntity.ok(examenes);
    }

    @PutMapping("/")
    public Pregunta put_actualizarPregunta(@RequestBody Pregunta pregunta){
        return preguntaService.actualizarPregunta(pregunta);
    }

    @DeleteMapping("/{preguntaId}")
    public void del_eliminarPregunta(@PathVariable("preguntaId") Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
    }

    @GetMapping("/examen/todos/{examenId}")
    public ResponseEntity<?> listarPreguntaDelExamenComoAdministrador(@PathVariable("examenId") Long examenId){
        Examen examen = new Examen();
        examen.setId(examenId);
        Set<Pregunta> preguntas = preguntaService.obtenerPreguntasDelExamen(examen);
        return ResponseEntity.ok(preguntas);
    }
}
