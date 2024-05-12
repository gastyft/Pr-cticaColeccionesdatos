package com.coleccionesDeDatos.libros;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GestorTreeMap implements GestorLibros{
    Map<String,Libro> librosTreeMap = new TreeMap<>();

    @Override
    public void agregarLibro(Libro libro) {
        try {
            librosTreeMap.put(libro.getTitulo(),libro);
        }
        catch (Exception e){
            System.out.println("Error en funcion agregar de TreeMap");
        }
    }

    @Override
    public void mostrarTodosLosLibros() {
        try {
            librosTreeMap.values().forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Error en funcion mostrar de TreeSet");
        }
    }

    @Override
    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> libroList = new ArrayList<>();
try{
    libroList = librosTreeMap.values().stream()
            .filter(libro -> libro.getAutor().equals(autor))
            .collect(Collectors.toList());
}catch (NullPointerException e){
    System.out.println("Error en buscar de TreeMap");
}
        return libroList;
    }

    @Override
    public List<Libro> listarLibrosOrdenadosPorTitulo() {
        List<Libro> libroList =new ArrayList<>();
        try {
            libroList.addAll(librosTreeMap.values());
        }catch (NullPointerException e){
            System.out.println("Error en Listar de TreeMap");
        }
        return libroList;
    }

    @Override
    public boolean eliminarLibro(String titulo) {
        boolean flag=false;
try {
    if(librosTreeMap.remove(titulo)!= null){ // Mediante el Key devuelve el objeto si es eliminado o null si no lo elimino
        flag=true;
    }
}catch (Exception e){
    System.out.println("Error en eliminar de TreeMap");
}
        return flag;
    }
}
