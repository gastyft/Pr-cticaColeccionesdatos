package com.coleccionesDeDatos.libros;

import java.util.Objects;

public class Libro implements  Comparable<Libro> { //Se puede utilizar compareTo para elegir con que comparar desde la clase
    //O sino asi desde el gestor
    //Set<Libro>  libroTreeSet = new TreeSet<>(Comparator.comparing(Libro::getTitulo));
    // Le Decis por cual criterio queres acomodar

    private static int autoId=0;
    private final int id;
   private  String titulo;
   private String autor;
   private int anioPublicacion;
  //  b. Constructor, getters, y métodos toString, equals, y hashCode.


    @Override
    public int compareTo(Libro otroLibro) {
        // Comparar libros por título de forma ascendente
        return this.titulo.compareTo(otroLibro.titulo);
    }

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.id= autoId++;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "\n-----------------------------------------------------------"+
                "\nLibro" +
                "\nid: " + id +
                "\ntitulo: " + titulo +
                "\nautor: " + autor +
                "\nanioPublicacion: " + anioPublicacion+
                "\n-----------------------------------------------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return getId() == libro.getId() && getAnioPublicacion() == libro.getAnioPublicacion() && Objects.equals(getTitulo(), libro.getTitulo()) && Objects.equals(getAutor(), libro.getAutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor,anioPublicacion);
    }

}
