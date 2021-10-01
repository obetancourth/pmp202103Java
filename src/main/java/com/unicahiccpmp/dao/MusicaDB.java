/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.dao;

import com.unicahiccpmp.musica.MusicItem;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.PreparedStatement;
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
                this._musicItems.clear();
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
    
    public MusicItem getMusicItemById(int id){
        try {
            String SQLGetByID = "SELECT * FROM MUSICA WHERE ID = ?;";
            PreparedStatement comando =  Conexion.getConexion().prepareStatement(SQLGetByID);
            comando.setInt(1, id);
            ResultSet misRegistro = comando.executeQuery();
            MusicItem registro = new MusicItem();
            while (misRegistro.next()) {
                registro.setId(misRegistro.getInt("ID"));
                registro.setNombre(misRegistro.getString("NOMBRE"));
                registro.setAlbum(misRegistro.getString("ALBUM"));
                registro.setAutores(misRegistro.getString("AUTORES"));
                break;
            }
            comando.close();

            return registro;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }   
    }
    
    public int updateMusicItem(MusicItem ItemToUpdate) {
        try {
            String SQLUpdate = "UPDATE MUSICA set NOMBRE=?, ALBUM=?, AUTORES=? where ID=?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLUpdate);
            
            comando.setString(1, ItemToUpdate.getNombre());
            comando.setString(2, ItemToUpdate.getAlbum());
            comando.setString(3, ItemToUpdate.getAutores());
            comando.setInt(4, ItemToUpdate.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     public int insertMusicItem(MusicItem ItemToInsert) {
        try {
            String SQLInsert = "INSERT INTO MUSICA (NOMBRE, ALBUM, AUTORES) values (?, ?, ?);";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLInsert);
            
            comando.setString(1, ItemToInsert.getNombre());
            comando.setString(2, ItemToInsert.getAlbum());
            comando.setString(3, ItemToInsert.getAutores());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     
    public int deleteMusicItem(MusicItem ItemToDelete) {
        try {
            String SQLDelete = "DELETE FROM MUSICA WHERE ID = ?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLDelete);
            
            comando.setInt(1, ItemToDelete.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
