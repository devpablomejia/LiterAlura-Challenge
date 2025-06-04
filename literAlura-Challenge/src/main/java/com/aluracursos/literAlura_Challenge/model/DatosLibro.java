package com.aluracursos.literAlura_Challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("languages")List<String> lenguajes,
        @JsonAlias("download_count") int numeroDescargas) {

    public String nombreAutor() {
        return autores != null && !autores.isEmpty()
                ? autores.get(0).nombre()
                : "Desconocido";
    }

    public String lenguaje() {
        return lenguajes != null && !lenguajes.isEmpty()
                ? lenguajes.get(0)
                : "Desconocido";
    }
}
