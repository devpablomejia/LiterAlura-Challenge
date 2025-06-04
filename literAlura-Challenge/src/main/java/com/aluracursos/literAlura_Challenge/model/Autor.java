package com.aluracursos.literAlura_Challenge.model;

import java.util.List;

public class Autor {
    private String nombre;
    private int añoNacimiento;
    private int añoMuerte;

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.añoMuerte = datosAutor.añoMuerte();
        this.añoNacimiento = datosAutor.añoNacimiento();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public int getAñoMuerte() {
        return añoMuerte;
    }

    public void setAñoMuerte(int añoMuerte) {
        this.añoMuerte = añoMuerte;
    }

    @Override
    public String toString() {
        return "AUTOR" +
                "\nnombre: " + nombre + "nacio: " + añoNacimiento + "murio: " + añoMuerte;
    }
}
