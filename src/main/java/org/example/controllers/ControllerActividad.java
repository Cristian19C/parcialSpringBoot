package org.example.controllers;

import org.example.entities.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.services.ServiceActividad;

import java.util.List;

@RestController
@RequestMapping(value = "/actividades")
public class ControllerActividad {

    @Autowired
    private ServiceActividad serviceActividad;

    @GetMapping
    public List<Actividad> getActividades(){
        return serviceActividad.getActividades();
    }


    @GetMapping("/{id}")
    public Actividad findById(@PathVariable String id){

        return serviceActividad.findById(id);
    }

    @PostMapping("/{id}")
    public Actividad save(@RequestBody Actividad actividad,@PathVariable Long id){
        if( serviceActividad.findById( actividad.getId()) == null ){
            return serviceActividad.save(actividad,id);
        }

        return null;
    }
}
