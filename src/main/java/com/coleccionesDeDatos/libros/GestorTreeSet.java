package com.coleccionesDeDatos.libros;

import java.util.*;
import java.util.stream.Collectors;

public class GestorTreeSet implements GestorLibros,TiemposCalculables {

    Set<Libro> libroTreeSet = new TreeSet<>(Comparator.comparing(Libro::getTitulo)); // Decirle como queres acomodar

    // idea para proyecto, armar metodo para ver como el usuario quiere la acomodacion
    //mediante un switch que devuelva criterioDeAcomodo
// y luego reemplazando la variable en(Libro::criterioDeAcomodo)
    @Override
    public void agregarLibro(Libro libro) {
        try {
            libroTreeSet.add(libro);
        } catch (NullPointerException | ClassCastException e) {
            System.out.println(" lista nula o error de casteo de clases ");
        }
    }

    @Override
    public void mostrarTodosLosLibros() {
        try{
            libroTreeSet.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Algo salio mal al mostrar lista TreeSet");
        }
    }

    @Override
    public List<Libro> listarLibrosOrdenadosPorTitulo() {
        List<Libro> libroList = new ArrayList<>();
        try{
                libroList.addAll(libroTreeSet);
        }catch (Exception e){
            System.out.println("Error en Listar libros ordenados");
        }

        return libroList;
    }

    @Override
    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> listLibros = new ArrayList<>();
        try {
            listLibros= libroTreeSet.stream()
                    .filter(libro -> libro.getAutor().equals(autor))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println("Algo salio mal en buscar libros TreeSet");
        }
        return listLibros;
    }

    @Override
    public boolean eliminarLibro(String titulo) {
        boolean flag=false;
        try {
            if(libroTreeSet.removeIf(libro -> libro.getTitulo().equals(titulo))) {
                System.out.println("Eliminado con exito");
                flag = true;
            }
        }catch (Exception e){
            System.out.println("Algo salio mal en eliminar TreeSet");
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
