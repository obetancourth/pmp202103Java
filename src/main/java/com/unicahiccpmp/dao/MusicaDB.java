/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.dao;

import com.unicahiccpmp.musica.MusicItem;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author obetancourth
 */

public class MusicaDB {
    private ArrayList _musicItems;
    
    public MusicaDB(){
        this._musicItems = new ArrayList<MusicItem>();
    }
    
    public ArrayList<MusicItem> getMusicItems(){
        return this.getMusicItems(false);
    }
    
    public void tableInitialize(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS MUSICA"
                        + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " NOMBRE TEXT NOT NULL,"
                        + " ALBUM TEXT NOT NULL,"
                        + " AUTORES TEXT NOT NULL"
                        + ")";
       
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCreate);
            comando.close();
        } catch( Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<MusicItem> getMusicItems(boolean forceLoad){
        try {
           if (forceLoad) {
                Statement comando =  Conexion.getConexion().createStatement();
                ResultSet misRegistro = comando.executeQuery("SELECT * from MUSICA;");

                while (misRegistro.next()) {
                    MusicItem registro = new MusicItem();
                    registro.setId(misRegistro.getInt("ID"));
                    registro.setNombre(misRegistro.getString("NOMBRE"));
                    registro.setAlbum(misRegistro.getString("ALBUM"));
                    registro.setAutores(misRegistro.getString("AUTORES"));
                    this._musicItems.add(registro);
                }
                comando.close();
           }
           return this._musicItems;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return this._musicItems;
        }   
    }
}
