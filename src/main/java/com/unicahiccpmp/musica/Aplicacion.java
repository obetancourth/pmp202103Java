/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.musica;


import com.unicahiccpmp.utilities.Layout;
import java.time.ZonedDateTime;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author obetancourth
 */
public class Aplicacion {
    
    private Scanner _EntradaTeclado;
    private ArrayList _MiMusica;
    private int _MiMusicIdCounter;
    public Aplicacion(Scanner EntradaTeclado) {
        this._EntradaTeclado = EntradaTeclado;
        this._MiMusica = new ArrayList<MusicItem>();  
        this._MiMusicIdCounter = 0;
    }
    
    public void activarEvento(String opcionMenu){
        switch(opcionMenu.toUpperCase()){
            case "M":
                this.mostrarRegistros();
                break;
            case "I":
                this.ingresarNuevoRegistro();
                break;
            case "A":
                this.actualizarRegistro();
                break;
            case "E":   
                this.eliminarRegistro();
                break;
            case "S":
                break;
            default:
                System.out.println("Opción no reconocida!!!");
                break;
        }
    }
    
    private void ingresarNuevoRegistro(){
        Layout.printHeader("Nuevo Registro de Canción");
        MusicItem nuevoMusicItem =  new MusicItem();
        nuevoMusicItem.setNombre(Layout.obtenerValorParaCampo("Nombre de la Cancion", "Canción XYZ", this._EntradaTeclado));
        nuevoMusicItem.setAutores(Layout.obtenerValorParaCampo("Nombre del autor", "Autor X", this._EntradaTeclado));
        nuevoMusicItem.setAlbum(Layout.obtenerValorParaCampo("Album", "Album Y", this._EntradaTeclado));
        int anio = Integer.parseInt(Layout.obtenerValorParaCampo("Año de Lanzamiento yyyy", "2020", this._EntradaTeclado));
        int mes = Integer.parseInt(Layout.obtenerValorParaCampo("Mes de Lanzamiento 1-12", "1", this._EntradaTeclado));
        int dia = Integer.parseInt(Layout.obtenerValorParaCampo("Día de Lanzamiento 1-31", "1", this._EntradaTeclado));
        //ZonedDateTime fechaLanzamiento = new ZonedDateTime();
        //fechaLanzamiento.setYear(anio);
        //fechaLanzamiento.setMonth(mes);
        //fechaLanzamiento.setDate(dia);
        //nuevoMusicItem.setFechaLanzamiento(fechaLanzamiento); 
        nuevoMusicItem.setId(this._MiMusicIdCounter + 1);
        this._MiMusicIdCounter ++;
        this._MiMusica.add(nuevoMusicItem);
        
        Layout.printSeparator();
        System.out.println(this._MiMusica.size());
    }
    
    private void mostrarRegistros(){
        Layout.printSeparator();
        ArrayList<String> columnas = new ArrayList<String>();
        columnas.add("Codigo");
        columnas.add("Cancion");
        columnas.add("Autor");
        columnas.add("Album");
        columnas.add("Lanzamiento");
        
        ArrayList<Integer> anchos = new ArrayList<Integer>();
        anchos.add(7);
        anchos.add(20);
        anchos.add(20);
        anchos.add(14);
        anchos.add(14);
        
        
        // |1234567890|123456789012345|
        try {
            //Imprimir encabezado
            Layout.imprimirEnColumna(columnas, anchos, "|");
            Layout.printSeparator();
            for(int i = 0; i< this._MiMusica.size(); i++){
                columnas = ((MusicItem) this._MiMusica.get(i)).obtenerCampos();
                Layout.imprimirEnColumna(columnas, anchos, "|");
            }
            
        } catch(Exception ex) {
            System.err.println("Error al imprimir " + ex.getMessage());
        }
    }
    
    private void actualizarRegistro(){
        Layout.printHeader("Actualizar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorParaCampo("Ingrese Codigo Registro", "0", this._EntradaTeclado));
        MusicItem selectMusic = null;
        for( int i=0; i < this._MiMusica.size(); i++){
            if( selectedId == ((MusicItem)this._MiMusica.get(i)).getId()) {
                selectMusic = (MusicItem)this._MiMusica.get(i);
                break;
            }
        }
        if (selectMusic == null ) {
            System.out.println("Registro solicitado no existe!!!");
        } else {
            selectMusic.setNombre(Layout.obtenerValorParaCampo("Nombre de la Cancion", selectMusic.getNombre(), this._EntradaTeclado));
            selectMusic.setAutores(Layout.obtenerValorParaCampo("Nombre del autor", selectMusic.getAutores(), this._EntradaTeclado));
            selectMusic.setAlbum(Layout.obtenerValorParaCampo("Album", selectMusic.getAlbum(), this._EntradaTeclado));
            int anio = Integer.parseInt(Layout.obtenerValorParaCampo("Año de Lanzamiento yyyy", "2020", this._EntradaTeclado));
            int mes = Integer.parseInt(Layout.obtenerValorParaCampo("Mes de Lanzamiento 1-12", "1", this._EntradaTeclado));
            int dia = Integer.parseInt(Layout.obtenerValorParaCampo("Día de Lanzamiento 1-31", "1", this._EntradaTeclado));
            Layout.printSeparator();
            System.out.println("Registro Actualizado Satisfactoriamente!!!");
        }
        
    }
    
    private void eliminarRegistro(){
        Layout.printHeader("Eliminar Registro");
        int selectedId = Integer.valueOf(Layout.obtenerValorParaCampo("Ingrese Codigo Registro", "0", this._EntradaTeclado));
        int encontradoEnIndice = -1;
        for( int i=0; i < this._MiMusica.size(); i++){
            if( selectedId == ((MusicItem)this._MiMusica.get(i)).getId()) {
                encontradoEnIndice = i;
                break;
            }
        }
        if (encontradoEnIndice>=0){
            Layout.printSeparator();
            String confirmado = Layout.obtenerValorParaCampo("¿Desea Eliminar este Registro? S - N", "N", this._EntradaTeclado);
            if (confirmado.toUpperCase().equals("S")){
                this._MiMusica.remove(encontradoEnIndice);
                Layout.printSeparator();
                System.out.println("Registro Eliminado Satisfactoriamente!!!");
            }
        } else {
            System.out.println("Registro solicitado no existe!!!");
        }
    
    }
    
    
}


// Clase  -->> Blue Print  plano de un casa

// Instancia de la Clase ---> Una representacion en Memoria unica de una Clase

// this->Instancia de la clase