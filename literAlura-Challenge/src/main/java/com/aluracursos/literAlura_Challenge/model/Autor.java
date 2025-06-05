package com.aluracursos.literAlura_Challenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private int añoNacimiento;
    private int añoMuerte;

    public Autor() {
    }

    public Autor(String nombre, int añoNacimiento, int añoMuerte) {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
        this.añoMuerte = añoMuerte;
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
                "\nnombre: " + nombre + " nacio: " + añoNacimiento + " murio: " + añoMuerte
                +"\n=======================================================================";
    }
}
