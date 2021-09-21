/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.musica;

import com.unicahiccpmp.utilities.Layout;
import java.util.Scanner;


/**
 *
 * @author obetancourth
 */
public class Main {
    
    public static void main (String[] args) {
        //Layout.printSeparator();
        //System.out.println("Musica App V1.0");
        //Layout.printSeparator();
        Layout.printHeader("Musica App V1.0");
        String OpcionMenu = "";
        
        Scanner entradaTeclado = new Scanner(System.in);
        
        Aplicacion musicApp = new Aplicacion(entradaTeclado);
        
        while (!(OpcionMenu.toUpperCase().equals("S"))) {
            Layout.printMenu();
            OpcionMenu = entradaTeclado.nextLine();

            System.out.println("Texto ingresado es igual a " + OpcionMenu);
            // Verificar las Opciones
            musicApp.activarEvento(OpcionMenu);
            
        }
        
        
    }
    
}
