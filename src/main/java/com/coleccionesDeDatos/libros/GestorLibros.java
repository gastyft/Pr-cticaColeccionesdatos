package com.coleccionesDeDatos.libros;

import java.util.List;

public interface GestorLibros {
    void agregarLibro(Libro libro);// Agrega un libro a la colección.

    boolean eliminarLibro(String titulo); // Elimina un libro por título y devuelve si la

    // operación fue exitosa.
    List<Libro> buscarLibrosPorAutor(String autor); //Devuelve una lista de libros de un

    // autor específico.
    List<Libro> listarLibrosOrdenadosPorTitulo(); //Devuelve una lista de libros

    // ordenados por título.
    void mostrarTodosLosLibros(); // Imprime todos los libros en la colección.

}
