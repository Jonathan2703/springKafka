package com.kafka.provider.service;

import com.kafka.provider.model.Curso;
import com.kafka.provider.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public CursoService(CursoRepository cursoRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.cursoRepository = cursoRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Curso createCurso(Curso curso) {
        Curso savedCurso = cursoRepository.save(curso);
        kafkaTemplate.send("estudiantes-Topic", curso);
        return savedCurso;
    }
}
