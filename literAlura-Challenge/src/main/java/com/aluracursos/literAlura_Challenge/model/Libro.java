package com.aluracursos.literAlura_Challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;

import java.util.Optional;
import java.util.OptionalInt;

public class Libro {
    private String titulo;
    private String nombreAutor;
    private String lenguaje;
    private int numeroDescargas;

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.nombreAutor = datosLibro.nombreAutor();
        this.lenguaje = datosLibro.lenguaje();
        this.numeroDescargas = datosLibro.numeroDescargas();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(int numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "LIBRO"
                +"\nTITULO: " + titulo
                +"\nAUTOR: " + nombreAutor
                +"\nLENGUAJE: " + lenguaje
                +"\nDESCARGAS: " + numeroDescargas;
    }
}
