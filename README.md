# 📚 LiterAlura-Challenge
Este es un sistema de línea de comandos desarrollado para gestionar y consultar información sobre libros y autores de forma sencilla y eficiente.

---
## 📑 Índice
- [📋 Funcionalidades](#-funcionalidades)
- [🔌 Integración con la API GutenDex](#-integración-con-la-api-gutendex)
- [🚀 Instalación y ejecución](#-instalación-y-ejecución)
- [🖥️ Tecnologías utilizadas](#-Tecnologías-utilizadas)



## 📋 Funcionalidades

Al ejecutar el programa, se mostrará el siguiente menú de opciones numéricas:
- **1 - Buscar Libro por Título**  
  Permite al usuario buscar un libro introduciendo su título o una parte de él. Muestra coincidencias encontradas.

- **2 - Listar Libros Registrados**  
  Muestra todos los libros que se encuentran actualmente registrados en el sistema.

- **3 - Listar Autores Registrados**  
  Presenta una lista con todos los autores disponibles en la base de datos, incluyendo información relevante.

- **4 - Listar Autores vivos en un determinado Tiempo**  
  El usuario introduce un rango de años y el sistema muestra los autores que estaban vivos durante ese periodo.

- **5 - Listar Libros por Lenguaje**  
  Filtra y muestra los libros según el idioma en que están escritos.

- **0 - Salir**  
  Finaliza el programa de forma segura.

---
## 🔌 Integración con la API GutenDex
Este sistema incorpora una integración con la API pública de GutenDex, una interfaz que da acceso al catálogo de libros del Proyecto Gutenberg.
Gracias a esta integración, el sistema puede enriquecer la búsqueda de libros y autores con miles de obras literarias de dominio público disponibles en línea.

### 📘 ¿Qué ofrece la API GutenDex?
Búsqueda de libros por título, autor, idioma, tema, etc.
Acceso a metadatos como: año de publicación, idioma, autores, número de descargas, y enlaces a los distintos formatos disponibles (HTML, ePub, Kindle, texto plano).
Servicio gratuito y sin necesidad de autenticación.

### 🛠️ Cómo se usa en el sistema
Buscar libros por título: Si no se encuentra un libro en la base de datos local, el sistema consulta automáticamente la API GutenDex para mostrar resultados relevantes.

## 🚀 Instalación y ejecución

1. **Clona este repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/nombre-del-repositorio.git

# 🖥️ Tecnologías utilizadas
- java
- spring
- postgresql
- git / githud
