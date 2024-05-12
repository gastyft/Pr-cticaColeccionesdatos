package com.coleccionesDeDatos;

import com.coleccionesDeDatos.libros.GestorHashSet;
import com.coleccionesDeDatos.libros.Libro;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.util.List;

public class Main {
    public static void main(String[] args){

// cargar la lista de array y luego cargar esos valores para las demas implementaciones
// para no escribir 50 veces libro.add

        GestorHashSet gestorHashSet = new GestorHashSet();/*
        Libro libro1 = new Libro("Baron Rojo", "Saint",1930);
        gestorHashSet.agregarLibro(libro1);
        Libro libro2 = new Libro("Messi","Messi",2022);
        gestorHashSet.agregarLibro(libro2); */
    gestorHashSet.mostrarTodosLosLibros();
      List<Libro> libroAMostrar = gestorHashSet.buscarLibrosPorAutor("Saint");

      libroAMostrar.forEach(System.out::println);

    }
}