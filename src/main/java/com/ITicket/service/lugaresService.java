/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.service;

import com.ITicket.entity.lugar;
import com.ITicket.repository.lugaresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlo
 */
@Service
public class lugaresService implements IIugaresService{
    
     @Autowired
    private lugaresRepository lugaresRepository;

    @Override
    public List<lugar> listCountry() {
        return (List<lugar>) lugaresRepository.findAll();
    }
}
