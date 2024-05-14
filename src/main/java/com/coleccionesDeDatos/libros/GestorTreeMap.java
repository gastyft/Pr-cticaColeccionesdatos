package com.coleccionesDeDatos.libros;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GestorTreeMap implements GestorLibros,TiemposCalculables{
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
