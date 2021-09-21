/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.musica;

import java.util.Scanner;
/**
 *
 * @author obetancourth
 */
public class Aplicacion {
    
    private Scanner _EntradaTeclado;
    
    public Aplicacion(Scanner EntradaTeclado) {
        this._EntradaTeclado = EntradaTeclado;
    }
    
    public void activarEvento(String opcionMenu){
        switch(opcionMenu.toUpperCase()){
            case "M":
                System.out.println("Mostrar Datos");
                break;
            case "I":
                System.out.println("Ingresar Registro");
                break;
            case "A":
                System.out.println("Actualizar Registro");
                break;
            case "E":   
                System.out.println("Eliminar Reginstro");
                break;
            default:
                System.out.println("Opción no reconocida!!!");
                break;
        }
    }
}


// Clase  -->> Blue Print  plano de un casa

// Instancia de la Clase ---> Una representacion en Memoria unica de una Clase

// this->Instancia de la clase