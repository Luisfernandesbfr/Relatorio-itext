package com.java.aula05.services;

import com.java.aula05.entities.VWAlunoCurso;
import com.java.aula05.reports.AlunoCursoReport;
import com.java.aula05.repositories.VWAlucoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VWAlunoCursoService {

    @Autowired
    private VWAlucoCursoRepository repository;


    public List<VWAlunoCurso> listarTodos(){
        return repository.findAll();

    }

    public byte[]gerarRelatorio(){

        return new AlunoCursoReport(listarTodos()).createPDF();

    }
}

