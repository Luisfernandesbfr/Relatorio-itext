package com.java.aula05.repositories;

import com.java.aula05.entities.VWAlunoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VWAlucoCursoRepository  extends JpaRepository<VWAlunoCurso, Long> {
}
