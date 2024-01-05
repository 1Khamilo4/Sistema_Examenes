package com.sistema.examenes.Services;

import com.sistema.examenes.Models.Examen;
import com.sistema.examenes.Models.Pregunta;

import java.util.Set;

public interface PreguntaService {

    Pregunta agregarPregunta(Pregunta pregunta);
    Pregunta actualizarPregunta(Pregunta pregunta);
    Set<Pregunta> obtenerPreguntas();
    Pregunta obtenerPregunta(Long pregunta_id);
    Set<Pregunta> obtenerPreguntasDelExamen(Examen examen);
    void eliminarPregunta(Long preguntaId);
}
