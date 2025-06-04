package com.aluracursos.literAlura_Challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaGutenberg(
        @JsonAlias("count") Integer total,
        @JsonAlias("results") List<DatosLibro> resultados
) {}
