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
import javax.persistence.Table;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "lugares")
public class lugar implements Serializable{
     @Id
    //El input que pusimos en el html, que dice id
    //el va a reconocer esto y va a detectar que es auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //estos atributos coinciden con la tabla de "paises" en la base de datos
    private long id;
    private String lugar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}
