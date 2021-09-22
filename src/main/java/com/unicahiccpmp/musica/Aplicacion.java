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
    public Aplicacion(Scanner EntradaTeclado) {
        this._EntradaTeclado = EntradaTeclado;
        this._MiMusica = new ArrayList<MusicItem>();  
    }
    
    public void activarEvento(String opcionMenu){
        switch(opcionMenu.toUpperCase()){
            case "M":
                System.out.println("Mostrar Datos");
                break;
            case "I":
                System.out.println("Ingresar Registro");
                this.ingresarNuevoRegistro();
                break;
            case "A":
                System.out.println("Actualizar Registro");
                break;
            case "E":   
                System.out.println("Eliminar Reginstro");
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
        this._MiMusica.add(nuevoMusicItem);
        
        Layout.printSeparator();
        System.out.println(this._MiMusica.size());
    }
}


// Clase  -->> Blue Print  plano de un casa

// Instancia de la Clase ---> Una representacion en Memoria unica de una Clase

// this->Instancia de la clase