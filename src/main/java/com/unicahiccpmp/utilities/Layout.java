package com.unicahiccpmp.utilities;

public class Layout {
    //Imprimir una linea de Separación
    public static void printSeparator () {
        System.out.println("================================================================================");
    }
    public static void printHeader (String header) {
        int headerLength = header.length();
        int startPoint = (int) Math.floor((80 - headerLength) / 2);
        String headerBuffer = "";
        for(int i = 0; i<startPoint; i++) {
            headerBuffer += " ";
        }
        headerBuffer += header;
        startPoint = headerBuffer.length();
        for (int i = startPoint ; i < 80; i++ ){
            headerBuffer += " ";
        }
        
        printSeparator();
        System.out.println(headerBuffer);
        printSeparator();
    }
    //CRUD
    public static void printMenu() {
        printHeader("Menu");
        
        System.out.println("\nM - Mostrar\nI - Ingresar\nA - Actualizar\nE - Eliminar\n\nS - Salir\n");
        printSeparator();
        System.out.println("Seleccione una opción : ");
        //Implementar esto para la tarea
        /*
        
        ================================================================================
                                          Menu
        ================================================================================
        
        M - Mostrar
        I - Ingresar
        A - Actualizar
        E - Eliminar
        
        S - Salir
        
        ================================================================================
        Selecciones una opción :
        
        */
    }
    
}
