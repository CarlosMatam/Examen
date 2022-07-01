/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.service;

import com.ITicket.entity.Evento;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface IEventoService {
    
     public List<Evento> getAllPersona();
     //vamos a obtener a una persona de la base de datos con el id
    public Evento getPersonaById ( long id);
    //guardar una nueva fila en la base de datos
    public void savePersona(Evento id);
    //elimina una fila de la base de datos
    public void delete(long id);
}
