package com.coleccionesDeDatos.libros;

import java.util.*;
import java.util.stream.Collectors;

public class GestorTreeSet implements GestorLibros {

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


}
