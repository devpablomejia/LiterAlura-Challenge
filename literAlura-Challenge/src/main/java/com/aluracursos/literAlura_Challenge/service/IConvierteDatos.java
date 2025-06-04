package com.aluracursos.literAlura_Challenge.service;

import java.util.List;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
