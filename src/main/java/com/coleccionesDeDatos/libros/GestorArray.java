package com.coleccionesDeDatos.libros;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorArray implements GestorLibros {

    List<Libro> libroList = new ArrayList<>();

    @Override
    public void agregarLibro(Libro libro) {

        try {
            libroList.add(libro);
        } catch (Exception e) {
            System.out.println("Error al agregar libro");
        }
    }

    @Override
    public List<Libro> listarLibrosOrdenadosPorTitulo() {
        List<Libro> librosOrdenados = new ArrayList<>(libroList);
        try {
            librosOrdenados.sort(Comparator.comparing(Libro::getTitulo));
            // librosOrdenados.stream().forEach(libro -> System.out.println(libro));
            librosOrdenados.forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Error en ordenacion" + e);
        }
        return librosOrdenados;
    }

    @Override
    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> librosPorAutor = new ArrayList<>();
        try {
            librosPorAutor = libroList.stream()
                    .filter(libro -> libro.getAutor().equals(autor))
                    .collect(Collectors.toList());

        } catch (NullPointerException e) {
            System.out.println("No se encontraron libros para este autor");
        }
        return librosPorAutor;
    }

    @Override
    public boolean eliminarLibro(String titulo) {
        boolean bool= false;
        try {
            Optional<Libro> libroAEliminar = libroList.stream()
                    .filter(libro -> libro.getTitulo().equals(titulo))
                    .findFirst();
            if (libroAEliminar.isPresent()) {
                libroList.remove(libroAEliminar.get());
                bool=true; // Devuelve verdadero si se encontró y eliminó el libro
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el titulo " + titulo);
        }
        return  bool;
    }// Ver si se genera un null pointer exception entonces tirar para arriba al main o menu e informar de ahi

    @Override
    public void mostrarTodosLosLibros() {
        try {
            libroList.forEach(System.out::println);
        }
        catch(NullPointerException e) {
            System.out.println("La lista esta vacia");
        }
    }
}


