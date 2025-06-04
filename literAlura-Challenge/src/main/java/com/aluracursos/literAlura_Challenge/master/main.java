package com.aluracursos.literAlura_Challenge.master;

import com.aluracursos.literAlura_Challenge.model.Autor;
import com.aluracursos.literAlura_Challenge.model.DatosLibro;
import com.aluracursos.literAlura_Challenge.model.Libro;
import com.aluracursos.literAlura_Challenge.model.RespuestaGutenberg;
import com.aluracursos.literAlura_Challenge.service.ConsumoAPI;
import com.aluracursos.literAlura_Challenge.service.ConversorDatos;

import java.util.Scanner;

public class main {
    private Scanner sc = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConversorDatos conversor = new ConversorDatos();

    public void mostrarMenu(){
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                           BIENVENIDOS A lITERALURA
                    =====================================
                    Digite una opcion numerica valida:
                    1 - Buscar Libro por Titulo. 
                    2 - Listar Libros Registrados.
                    3 - Listar Autores Registrados.
                    4 - Listar Autores vivos en un determinado Tiempo.
                    5 - Listar Libros por Lenguaje.
                    
                    0 - Salir
                    =====================================
                    desarrollado con <3 by devPabloMejia
                    =====================================
                    """;
            System.out.println(menu);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                        buscarLibroWeb();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private DatosLibro getDatosLibros() {
        System.out.print("Escribe el nombre del libro que deseas buscar: ");
        var nombreLibro = sc.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));
        System.out.println(json);
        RespuestaGutenberg respuestaGutenberg = conversor.obtenerDatos(json, RespuestaGutenberg.class);
        DatosLibro datos = respuestaGutenberg.resultados().get(0);
        return datos;
    }

    private void buscarLibroWeb() {
        DatosLibro datos = getDatosLibros();
        Libro libro = new Libro(datos);
        //repository.save(libro);
        System.out.println(libro);
    }
}
