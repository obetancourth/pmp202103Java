/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.musica;

import java.util.Date;

/**
 *
 * @author obetancourth
 */
public class MusicItem {

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _autores
     */
    public String getAutores() {
        return _autores;
    }

    /**
     * @param _autores the _autores to set
     */
    public void setAutores(String _autores) {
        this._autores = _autores;
    }

    /**
     * @return the _fechaLanzamiento
     */
    public Date getFechaLanzamiento() {
        return _fechaLanzamiento;
    }

    /**
     * @param _fechaLanzamiento the _fechaLanzamiento to set
     */
    public void setFechaLanzamiento(Date _fechaLanzamiento) {
        this._fechaLanzamiento = _fechaLanzamiento;
    }

    /**
     * @return the _album
     */
    public String getAlbum() {
        return _album;
    }

    /**
     * @param _album the _album to set
     */
    public void setAlbum(String _album) {
        this._album = _album;
    }
    private int _id;
    private String _nombre;
    private String _autores;
    private Date _fechaLanzamiento;
    private String _album;
    
    public MusicItem(){
        this._id = 0;
        this._nombre = "";
        this._autores = "";
        this._album = "";
        this._fechaLanzamiento =  new Date();
    }
    
    public MusicItem(int id, String nombre, String autores, String album, Date fechaLanzamiento) {
        this._id = id;
        this._nombre = nombre;
        this._autores = autores;
        this._album = album;
        this._fechaLanzamiento =  fechaLanzamiento;
    }
    // setters y getters 
    
    
    
}
