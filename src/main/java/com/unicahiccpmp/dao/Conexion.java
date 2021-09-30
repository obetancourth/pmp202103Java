/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author obetancourth
 * 
 * Patron SINGLETON
 */
public class Conexion {
    private static Connection _conexion = null;
    
    private Conexion(){

    }
    
    public static Connection getConexion(){
        try {
            if(_conexion == null){
                Class.forName("org.sqlite.JDBC");
                _conexion = DriverManager.getConnection("jdbc:sqlite:musicadb.db");
                return _conexion;
            } else {
                return _conexion;
            }
        
        } catch (Exception ex){
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }
}

// Conexion xy = new Conexion();   no se permite por la 

// Connection algunaConexion = Conexion.getConexion();