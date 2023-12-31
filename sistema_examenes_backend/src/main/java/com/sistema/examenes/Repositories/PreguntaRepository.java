package com.sistema.examenes.Repositories;

import com.sistema.examenes.Models.Examen;
import com.sistema.examenes.Models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    Set<Pregunta> findByExamen(Examen examen);
}
