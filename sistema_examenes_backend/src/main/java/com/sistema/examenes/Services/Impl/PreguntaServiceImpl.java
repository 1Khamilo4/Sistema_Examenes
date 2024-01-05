package com.sistema.examenes.Services.Impl;

import com.sistema.examenes.Models.Examen;
import com.sistema.examenes.Models.Pregunta;
import com.sistema.examenes.Repositories.PreguntaRepository;
import com.sistema.examenes.Services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public Pregunta agregarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Pregunta actualizarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Set<Pregunta> obtenerPreguntas() {
        return new LinkedHashSet<>(preguntaRepository.findAll()) ;
    }

    @Override
    public Pregunta obtenerPregunta(Long pregunta_id) {
        return preguntaRepository.findById(pregunta_id).get();
    }

    @Override
    public Set<Pregunta> obtenerPreguntasDelExamen(Examen examen) {
        return preguntaRepository.findByExamen(examen);
    }

    @Override
    public void eliminarPregunta(Long preguntaId) {
        Pregunta pregunta = new Pregunta();

        pregunta.setPreguntaId(preguntaId);

        preguntaRepository.delete(pregunta);
    }
}
