package com.coleccionesDeDatos.libros;

import java.util.*;
import java.util.stream.Collectors;

public class GestorLinkedList implements GestorLibros,TiemposCalculables {

    LinkedList<Libro> linkedList = new LinkedList<>();

    @Override
    public void agregarLibro(Libro libro) {
        try {
            linkedList.add(libro);
        } catch (Exception e) {
            System.out.println("Error en agregar Libro en Linked List");
        }
    }

    @Override
    public void mostrarTodosLosLibros() {
        try {
            linkedList.forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("La lista esta vacia. No se puede mostrar nada");
        }
    }

    @Override
    public List<Libro> listarLibrosOrdenadosPorTitulo() {

        List<Libro> listaOrdenada = new ArrayList<>(linkedList);
        listaOrdenada.sort(Comparator.comparing(Libro::getTitulo));
        return listaOrdenada;
    }

    @Override
    public List<Libro> buscarLibrosPorAutor(String autor) {
List<Libro> listaLibrosAutor = new ArrayList<>();
try{

        listaLibrosAutor= linkedList.stream()
                .filter(libro -> libro.getAutor().equals(autor))
                .collect(Collectors.toList());

}catch (NullPointerException e){
    System.out.println("No se encontraron los libros del autor " + autor);
}

        return listaLibrosAutor;
    }

    @Override
    public boolean eliminarLibro(String titulo) {
        boolean flag =false;
        try {
            if(linkedList.removeIf(libro -> libro.getTitulo().equals(titulo))) {
                flag= true;
            }
        }catch (Exception e)
        {
            System.out.println("Ha ocurrido un error en eliminar de LinkedList");
        }

        return flag;
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
