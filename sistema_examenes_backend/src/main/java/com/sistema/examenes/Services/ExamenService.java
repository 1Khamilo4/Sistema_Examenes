package com.sistema.examenes.Services;

import com.sistema.examenes.Models.Examen;

import java.util.Set;

public interface ExamenService {

    Examen agregarExamen(Examen examen);

    Examen actualizarExamen(Examen examen);

    Set<Examen> obtenerExamenes();

    Examen obtenerExamen(Long examenId);

    void eliminarExamen(Long examenId);
}
