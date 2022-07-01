/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.service;

import com.ITicket.entity.Evento;
import com.ITicket.repository.EventoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlo
 */
@Service
public class EventoService implements IEventoService{
     @Autowired
    private EventoRepository eventoRepository;
    //Como personaRepository es el que se conecta en la base de datos, nos interesa llamarlo aca

    @Override
    public List<Evento> getAllPersona() {
        return (List<Evento>)eventoRepository.findAll();
    }

    @Override
    public Evento getPersonaById(long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public void savePersona(Evento evento) {
      eventoRepository.save(evento);
    }

    @Override
    public void delete(long id) {
      eventoRepository.deleteById(id);
    }
 
}
