package com.aluracursos.literAlura_Challenge.repository;

import com.aluracursos.literAlura_Challenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a " +
            "WHERE a.añoNacimiento <= :fin " +
            "AND (a.añoMuerte IS NULL OR a.añoMuerte >= :inicio)")
    List<Autor> findAutoresVivosEnPeriodo(@Param("inicio") int inicio, @Param("fin") int fin);
}
