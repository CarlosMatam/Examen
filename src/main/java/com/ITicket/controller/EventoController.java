/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.controller;

import com.ITicket.entity.Evento;
import com.ITicket.entity.lugar;
import com.ITicket.service.IEventoService;
import com.ITicket.service.IIugaresService;
import com.ITicket.service.lugaresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author carlo
 */
@Controller
public class EventoController {
    
     @Autowired
    private IIugaresService lugarService;
    
     @Autowired
    private IEventoService eventoService;
    
    
    //Para ver las tablas, jalar la info de mysql, leerlo
    @GetMapping("/evento")
    //con este model le pasamos informacion a mi html de personas
    public String index (Model model){
        List<Evento> listaEvento = eventoService.getAllPersona();
        model.addAttribute("titulo", "Tabla de Eventos");
        model.addAttribute("eventos", listaEvento);
        //devolviendo un html de personas
        return "eventos";
    }
    //El get mapping es el URL
     @GetMapping("/eventoN")
    public String crearEvento (Model model){
        List<lugar> listaLugares = lugarService.listCountry();
        model.addAttribute("evento", new Evento()); //le vamos a insertar un objecto
        model.addAttribute("lugares", listaLugares);
        //Aqui tenemos que ponerle igual al html que vamos a utilizar
        return "crear";
    }
    //como no queremos obtener nada, no es un getmapping
    
      @PostMapping("/save")
      //Aqui lo que vamos a hacer es enviarle del html , informacion al metodo
    public String guardarEvento (@ModelAttribute Evento evento){// siempre pasan el objecto
        eventoService.savePersona(evento);// aqui ya lo estamos guardamdo en la base de datos
        
        return "redirect:/evento";// con este redirect nos va a mandar a la lista que ya tenemos, mostrando ya las personas
    }// mostrando el html personas, confirmando que si se guardo
    
    @GetMapping("/editEvento/{id}")//Como para modificar una persona ocupamos un id, tonces dentro del mismo url se lo vamos a pasar, para poder buscarlo en la base de datos
    public String editarEvento (@PathVariable("id") long idEvento ,Model model){// el id persona es log, porque en la clase persona pusimos el id de variable LONG
        //PathVariable es cuando se va a modificar              este model es para pasarle la informacion
        
        //Aqui llamamos a la persona que queremos editar
        Evento evento = eventoService.getPersonaById(idEvento);//le pasamos el id persona que pedimos en el parametro, lo pedimos en el url
        List<lugar> listalugares = lugarService.listCountry();// como queremos editar el pais, lo llamamos
       // model.addAttribute("persona", new Persona());//Como ya tenemos el objecto creado no le ponemos new Persona  
        model.addAttribute("evento", evento);
        model.addAttribute("lugares", listalugares);
        //cuando vamos a editar una persona, igualmente hay que llenar el formulario que se lleno cuando se estaban creando
        //por eso se returna crear y no "editar", pero si se hiciera asi estaria igualmente bien
        return "crear";
    }
    
    @GetMapping("/delete/{id}")//                                        
     public String eliminarPersona (@PathVariable("id") long idEvento ){// el id persona es log, porque en la clase persona pusimos el id de variable LONG
        //PathVariable es cuando se va a modificar             como no ocupamos pasar nada le quitamos el model
        
        //Aqui llamamos a la persona que queremos editar
        eventoService.delete(idEvento);//le pasamos el id persona que pedimos en el parametro, lo pedimos en el url
       
      
        return "redirect:/evento";
    }
}
