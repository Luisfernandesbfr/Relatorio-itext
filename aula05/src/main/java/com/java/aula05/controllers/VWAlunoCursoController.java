package com.java.aula05.controllers;

import com.java.aula05.services.VWAlunoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunocurso")
public class VWAlunoCursoController {
    @Autowired
    private VWAlunoCursoService service;

    @GetMapping("/listar")
    public ResponseEntity listarTodos() {
        return ResponseEntity.ok(service.listarTodos());

    }

    @GetMapping("/gerar/relatorio")
    public ResponseEntity gerarRelatorio() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment","aluno-curso.pdf");


        return ResponseEntity.ok().headers(headers).body(service.gerarRelatorio());
    }
}