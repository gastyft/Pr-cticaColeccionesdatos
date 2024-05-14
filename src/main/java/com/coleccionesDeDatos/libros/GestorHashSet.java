package com.coleccionesDeDatos.libros;

import java.util.*;
import java.util.stream.Collectors;

public class GestorHashSet implements GestorLibros,TiemposCalculables {

    Set<Libro> libroSet = new HashSet<>();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void agregarLibro(Libro libro) {
        try {
            if (libroSet.contains(libro))
                System.out.println("Este libro ya existe, asi que no se agregara");
            else
                libroSet.add(libro);
        } catch (NullPointerException e) {
            System.out.println("La lista esta vacia");
        }
    }

    @Override
    public List<Libro> listarLibrosOrdenadosPorTitulo() {
        List<Libro> libroList = new ArrayList<>();
        try {
            //Como HashSet no permite ordenacion por si sola se implementa el pasaje a TreeSet
            Set<Libro> libroTree = new TreeSet<>(libroSet);
            libroList.addAll(libroTree);
        } catch (NullPointerException e) {
            System.out.println("Error en funcion listar ordenados en HashSet");
        }
        return libroList;
    }

    @Override
    public void mostrarTodosLosLibros() {
        try {
            if(!libroSet.isEmpty()){
            Iterator<Libro> libroIterator = libroSet.iterator();
            while (libroIterator.hasNext()) {
                System.out.println(libroIterator.next());
            }
        }else System.out.println("No hay libros para mostrar");
        } catch (NullPointerException e) {
            System.out.println("Algo salio mal en funcion mostrar HashSet " + e);
        }
    }
    @Override
    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> librosDelAutor = new ArrayList<>();
        try {
            librosDelAutor=libroSet.stream()
                    .filter(libro -> libro.getAutor().equals(autor))
                    .collect(Collectors.toList());
            if( librosDelAutor.isEmpty())
                System.out.println("No hay autores con libros asignados");
            }
        catch (Exception e) {
            System.out.println("Error al buscar libros por autor: " + e.getMessage());
        }
        return librosDelAutor;
        }

   public boolean eliminarLibro(String titulo)  {
        boolean flag = false;
        try {
            Optional<Libro> libroAEliminar = libroSet.stream()
                    .filter(libro -> libro.getTitulo().equals(titulo))
                    .findFirst();
            if (libroAEliminar.isPresent()) {
                libroSet.remove(libroAEliminar.get()); // Elimina el libro del libroSet si está presente
                flag = true;
            }
        } catch (NullPointerException e) {
            System.out.println("No se encontro el titulo a eliminar");
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

