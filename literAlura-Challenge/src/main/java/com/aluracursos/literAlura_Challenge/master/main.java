package com.aluracursos.literAlura_Challenge.master;

import com.aluracursos.literAlura_Challenge.model.*;
import com.aluracursos.literAlura_Challenge.repository.AutorRepository;
import com.aluracursos.literAlura_Challenge.repository.LibroRepository;
import com.aluracursos.literAlura_Challenge.service.ConsumoAPI;
import com.aluracursos.literAlura_Challenge.service.ConversorDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private Scanner sc = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConversorDatos conversor = new ConversorDatos();
    private LibroRepository booksRepository;
    private AutorRepository autorRepository;

    public main(LibroRepository booksRepository, AutorRepository autorRepository) {
        this.booksRepository = booksRepository;
        this.autorRepository = autorRepository;
    }

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
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresEnDeterminadoAño();
                    break;
                case 5:
                    mostrarLibrosPorLengauje();
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
        RespuestaGutenberg respuestaGutenberg = conversor.obtenerDatos(json, RespuestaGutenberg.class);
        DatosLibro datos = respuestaGutenberg.resultados().get(0);
        return datos;
    }

    private void buscarLibroWeb() {
        DatosLibro datos = getDatosLibros();
        Libro libro = new Libro(datos);
        Autor autor = new Autor(datos.nombreAutor(), datos.naciemientoAutor(), datos.muerteAutor());
        booksRepository.save(libro);
        autorRepository.save(autor);
        System.out.println(libro);
        System.out.println("REGISTROS EXITOSOS");
    }

    private void listarLibrosRegistrados(){
       List<Libro> libros = booksRepository.findAll();
        System.out.println("ACTUALMENTE CONTAMOS CON "+ libros.size()
                +" LIBROS REGISTRADOS: ");
       libros.forEach(System.out::println);
    }

    private void listarAutoresRegistrados(){
        List<Autor> autors = autorRepository.findAll();
        System.out.println("ACTUALMENTE CONTAMOS CON "+ autors.size()
                +" AUTORES REGISTRADOS: ");
        autors.forEach(System.out::println);
    }

    private void listarAutoresEnDeterminadoAño(){
        System.out.println("PARA DETERMINAR EL PERIODO DE TIEMPO INGRESE LOS SIGUIENTES DATOS:");
        System.out.print("ingrese su primer año: ");
        int año1 = sc.nextInt();
        System.out.print("ingrese su segundo año: ");
        int año2 = sc.nextInt();
        List<Autor> autoresVivos = autorRepository.findAutoresVivosEnPeriodo(año1, año2);
        if (autoresVivos.isEmpty() || autoresVivos == null){
            System.out.println("NO HAY AUTORES VIVOS EN ESE PERIODO DE TIEMPO");
            return;
        }
        System.out.println("LOS AUTORES VIVOS EN EL PERIODO COMPRENDIDO ENTRE "
                + año1 + "-" + año2 + " SON LOS SIGUIENTES:");
        autoresVivos.forEach(System.out::println);
    }

    private List<Libro> listarLibroPorLenguaje(){
        List<Libro> libros = new ArrayList<>();
        System.out.println("""
                    escoja uno de los siguiente idiomas para listar los libros:
                    (1) Español
                    (2) Ingles
                """);
        int opcion = sc.nextInt();
       switch (opcion){
           case 1 -> {
               return libros = booksRepository.findBylenguaje("es");
           }
           case 2 -> {
               return libros = booksRepository.findBylenguaje("en");
           }
           default -> {
               System.out.println("OPCION INVALIDA");
           }
       }
        return libros;
    }

    private void mostrarLibrosPorLengauje(){
        List<Libro> librosPorLenguaje = listarLibroPorLenguaje();
        if (librosPorLenguaje == null || librosPorLenguaje.isEmpty()){
            System.out.println("NO HAY LIBROS EN DICHO IDIOMA.");
        }else {
            System.out.println("LOS SIGUIENTE LIBROS ESTAN LISTADOS EN EL IDIOMA SELECCIONADO: ");
            librosPorLenguaje.stream()
                    .map(l-> l.getTitulo())
                    .forEach(System.out::println);
        }
    }
}
