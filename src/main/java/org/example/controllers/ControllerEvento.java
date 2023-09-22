package org.example.controllers;

import org.example.entities.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.example.services.ServiceEvento;
import org.example.responses.ResponseHandler;
import java.util.List;

@RestController
@RequestMapping(value = "/eventos")
public class ControllerEvento {

    @Autowired
    private ServiceEvento serviceEvento;


    @GetMapping
    public ResponseEntity<Object> findAll() {

        try {
            List<Evento> result = serviceEvento.findAll();

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Evento evento){
        try{
            Evento evento1 = serviceEvento.save( evento );

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, evento1);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        try{
            Evento evento = serviceEvento.findById( id );

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, evento);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
