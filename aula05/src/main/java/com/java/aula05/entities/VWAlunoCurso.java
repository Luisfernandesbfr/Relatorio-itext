package com.java.aula05.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="vw_aluno_curso")
public class VWAlunoCurso {

    @Id
    @Column(name = "idAluno")
    private Long id;

    @Column( name = "nomeAluno", length = 50,nullable = false)
    private String nomeAluno;
    @Column (name = "emailAluno",length = 50,unique = true)
    private String emailAluno;

    @Column (name = "dtMatricula")
    private Date dtMatricula;

    @Column (name = "descricaoCurso")
    private String descricaoCurso;



}
