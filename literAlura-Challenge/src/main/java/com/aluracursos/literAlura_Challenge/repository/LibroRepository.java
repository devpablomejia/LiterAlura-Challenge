package com.aluracursos.literAlura_Challenge.repository;


import com.aluracursos.literAlura_Challenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findBylenguaje(String lenguaje);
}
