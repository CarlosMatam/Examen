/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author carlo
 */

@Entity
@Table(name = "Evento")
public class Evento implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //El tipo de variable aqui tiene que coincidir con el de mysql
    private long id;
    private String Artista;
    private String Costo;
    private String Fecha;
    private String CapacidadM;
    

     //Aqui estamos haciendo la relacion de muchos a uno
    @ManyToOne
    //este es el fk de la bd, por eso hacemos la relacion
    @JoinColumn(name ="lugares_id" )
    //como estamos haciendo la referencia a otra tabla, es por eso esta variable, una variable de tipo pais.
    private lugar lugar;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getCapacidadM() {
        return CapacidadM;
    }

    public void setCapacidadM(String CapacidadM) {
        this.CapacidadM = CapacidadM;
    }

    public lugar getLugar() {
        return lugar;
    }

    public void setLugar(lugar lugar) {
        this.lugar = lugar;
    }

 

   
    
   
   

}
