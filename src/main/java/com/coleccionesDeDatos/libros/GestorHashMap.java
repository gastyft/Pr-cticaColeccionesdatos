package com.coleccionesDeDatos.libros;

import java.util.*;
import java.util.stream.Collectors;

public class GestorHashMap implements GestorLibros, TiemposCalculables {

    Map<String , Libro> libroMap = new HashMap<>();

    @Override
    public void agregarLibro(Libro libro) {
        try {
            libroMap.put(libro.getTitulo(), libro);
        } catch (Exception e) {
            System.out.println("Error al agregar libro en HashMap");
        }
    }

    @Override
    public void mostrarTodosLosLibros() {
        try {
            libroMap.entrySet().stream()   //Interpolacion
                    .map(entry -> STR."Título: \{entry.getKey()}, Autor: \{entry.getValue().getAutor()}")
                    .forEach(System.out::println);
        if(libroMap.isEmpty())
            System.out.println("La lista esta vacia");

        }
        catch (NullPointerException e){
            System.out.println("Error en mostrar HashMap");
        }
        }

    @Override
    public boolean eliminarLibro(String titulo) {
        boolean flag =false;
     try {
         if(libroMap.remove(titulo)!= null) { //REMOVE EN ESTE CASO DEVUELVE EL OBJETO SI ELIMINA O NULL SI NO LO ELIMINA
             System.out.println("Eliminado con exito");
             flag=true;
         }
         else System.out.println("No se encontro el titulo a eliminar");

     }catch (Exception e){
         System.out.println("Problema en funcion eliminar de HashMap");
     }
        return flag;
    }

    @Override
    public List<Libro> buscarLibrosPorAutor(String autor) {
       List<Libro> libroList = new ArrayList<>();
       try{
           libroList = libroMap.values().stream() //pasarle .values() primero para usar stream()
                   .filter(libro -> libro.getAutor().equals(autor))//Obtiene objeto libro
                   .collect(Collectors.toList());
       }
        catch (NullPointerException e)
        {
            System.out.println("Error en buscar HashMap");
        }
       return libroList;
    }

    @Override
    public List<Libro> listarLibrosOrdenadosPorTitulo() {
        List<Libro> libroList = new ArrayList<>(); //TODO Preguntar por usar  TreeMap o usar .sort para acomodar
        try //Se puede primero pasar   a la lista y luego acomodar con .sort(Comparator.comparing(Libro::getTitulo));
                //O se arma un treeMap y luego addAll a la lista a devolver
                //Preguntar cual es mas efectivo porque en los dos casos estas creando 2 listas nuevas
        {
        //    libroList.addAll(libroMap.values());
      //    libroList.sort(Comparator.comparing(Libro::getTitulo));
//De las dos formas funciona
           Map<String,Libro> libroTreeMap = new TreeMap<>(libroMap);
           libroList.addAll(libroTreeMap.values());
        }catch (NullPointerException e){
            System.out.println("Error en funcion listarOrdenados en HashMap");
        }
        return libroList;
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
