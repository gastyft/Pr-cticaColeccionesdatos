package com.coleccionesDeDatos.libros;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorArray implements GestorLibros, TiemposCalculables {

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
        boolean bool = false;
        try {
            Optional<Libro> libroAEliminar = libroList.stream()
                    .filter(libro -> libro.getTitulo().equals(titulo))
                    .findFirst();
            if (libroAEliminar.isPresent()) {
                libroList.remove(libroAEliminar.get());
                bool = true; // Devuelve verdadero si se encontró y eliminó el libro
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el titulo " + titulo);
        }
        return bool;
    }// Ver si se genera un null pointer exception entonces tirar para arriba al main o menu e informar de ahi

    @Override
    public void mostrarTodosLosLibros() {
        try {
            libroList.forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("La lista esta vacia");
        }
    }

    public long agregarTime() {
        long startTime = System.nanoTime();

// calculo tiempos

        Libro libro1 = new Libro("Baron Rojo", "Saint", 1930);
        agregarLibro(libro1);
        Libro libro2 = new Libro("El curioso caso de Benjamín Button", "Scott Fitzgerald", 1921);
        agregarLibro(libro2);
        Libro libro3 = new Libro("La Iliada y La Odisea", "Homero", -1500);
        agregarLibro(libro3);

// Por ejemplo, realizar una operación intensiva en términos de tiempo

        long endTime = System.nanoTime();


        return endTime - startTime;
    }

    public long eliminarTime() {
        long start = System.nanoTime();
        eliminarLibro("Baron Rojo");
        long end = System.nanoTime();

        return end - start;
    }

    public long buscarTime(){
        long start=System.nanoTime();
        buscarLibrosPorAutor("La Iliada y La Odisea");
        long end= System.nanoTime();
        return  end-start;
    }
    public long listarTime(){
        long start = System.nanoTime();
        System.out.println(listarLibrosOrdenadosPorTitulo());

    long end= System.nanoTime();
        return end-start;
    }

}


