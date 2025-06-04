package com.aluracursos.literAlura_Challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") int añoNacimiento,
    @JsonAlias("death_year") int añoMuerte) {}

