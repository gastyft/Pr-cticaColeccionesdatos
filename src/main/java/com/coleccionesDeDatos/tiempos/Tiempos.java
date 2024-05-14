package com.coleccionesDeDatos.tiempos;

import com.coleccionesDeDatos.libros.*;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Tiempos {

    GestorHashSet gestorHashSet = new GestorHashSet();
    GestorTreeSet gestorTreeSet = new GestorTreeSet();
    GestorHashMap gestorHashMap = new GestorHashMap();
    GestorTreeMap gestorTreeMap = new GestorTreeMap();
    GestorArray gestorArray = new GestorArray();
    GestorLinkedList gestorLinkedList = new GestorLinkedList();
    long menorTiempoAgregar;
    long menorTiempoBuscar;
    long menorTiempoEliminar;
    long menorTiempoListar;
    String nombreAgregar;
    String nombreBuscar;
    String  nombreEliminar;
    String nombreListar;
    public Tiempos(){

    }
    String[] nombresGestores = {"Array", "HashSet", "HashMap", "TreeMap", "TreeSet", "LinkedList"};
// Estan acomodados como los cargo en todos los casos
    public void agregarTiempo(){
        //TIEMPOS AGREGAR
        List<Long> tiempos = new ArrayList<>();

// Agregar los tiempos a la lista
        tiempos.add(gestorArray.agregarTime());
        tiempos.add(gestorHashSet.agregarTime());
        tiempos.add(gestorHashMap.agregarTime());
        tiempos.add(gestorTreeMap.agregarTime());
        tiempos.add(gestorTreeSet.agregarTime());
        tiempos.add(gestorLinkedList.agregarTime());

        menorTiempoAgregar = Collections.min(tiempos);
    int indiceDelMenor = tiempos.indexOf(menorTiempoAgregar);
          nombreAgregar =nombresGestores[indiceDelMenor];

    }
    public void eliminarTiempo(){
        //TIEMPOS ELIMINAR
        List<Long> tiempos = new ArrayList<>();

// Agregar los tiempos a la lista
        tiempos.add(gestorArray.eliminarTime());
        tiempos.add(gestorHashSet.eliminarTime());
        tiempos.add(gestorHashMap.eliminarTime());
        tiempos.add(gestorTreeMap.eliminarTime());
        tiempos.add(gestorTreeSet.eliminarTime());
        tiempos.add(gestorLinkedList.eliminarTime());

        menorTiempoEliminar = Collections.min(tiempos);
        int indiceDelMenor = tiempos.indexOf(menorTiempoEliminar);
         nombreEliminar  =nombresGestores[indiceDelMenor];

    }
    public void buscarTiempo(){
        //TIEMPOS BUSCAR
        List<Long> tiempos = new ArrayList<>();

// Agregar los tiempos a la lista
        tiempos.add(gestorArray.buscarTime());
        tiempos.add(gestorHashSet.buscarTime());
        tiempos.add(gestorHashMap.buscarTime());
        tiempos.add(gestorTreeMap.buscarTime());
        tiempos.add(gestorTreeSet.buscarTime());
        tiempos.add(gestorLinkedList.buscarTime());

        menorTiempoBuscar = Collections.min(tiempos);
        int indiceDelMenor = tiempos.indexOf(menorTiempoBuscar);
         nombreBuscar  =nombresGestores[indiceDelMenor];

    }
    public void listarTiempo(){
        //TIEMPOS LISTAR
        List<Long> tiempos = new ArrayList<>();

// Agregar los tiempos a la lista
        tiempos.add(gestorArray.listarTime());
        tiempos.add(gestorHashSet.listarTime());
        tiempos.add(gestorHashMap.listarTime());
        tiempos.add(gestorTreeMap.listarTime());
        tiempos.add(gestorTreeSet.listarTime());
        tiempos.add(gestorLinkedList.listarTime());

        menorTiempoListar = Collections.min(tiempos);
        int indiceDelMenor = tiempos.indexOf(menorTiempoListar);
       nombreListar =nombresGestores[indiceDelMenor];

    }
        public void mostrarTiempos(){

            agregarTiempo();
            eliminarTiempo();
            buscarTiempo();
            listarTiempo();
            System.out.println("AGREGAR");
            System.out.println("El tiempo menor es del gestor "+ nombreAgregar + " con tiempo de "+ menorTiempoAgregar);
            System.out.println("----------------------------------------------------");
            System.out.println("ELIMINAR");
            System.out.println("El tiempo menor es del gestor "+ nombreEliminar + " con tiempo de "+ menorTiempoEliminar);
            System.out.println("----------------------------------------------------");
            System.out.println("BUSCAR");
            System.out.println("El tiempo menor es del gestor "+ nombreBuscar + " con tiempo de "+ menorTiempoBuscar);
            System.out.println("----------------------------------------------------");
            System.out.println("LISTAR ORDENADO");
            System.out.println("El tiempo menor es del gestor "+ nombreListar + " con tiempo de "+ menorTiempoListar);
            System.out.println("----------------------------------------------------");
        }

}
