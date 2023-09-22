package org.example.services;

import org.example.entities.Actividad;
import org.example.entities.Evento;
import org.example.repositories.RepositoryEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repositories.RepositoryActividad;


import java.util.List;
import java.util.Optional;

@Service
public class ServiceActividad {

    @Autowired
    private RepositoryEvento repositoryEvento;

    @Autowired
    private RepositoryActividad repositoryActividad;

    public List<Actividad> getActividades(){

        return repositoryActividad.findAll();
    }

    public Actividad findById(String id) {

        Optional<Actividad> optionalActividad = repositoryActividad.findById( id );

        return optionalActividad.isPresent() ? optionalActividad.get() : null;
    }

    public Actividad save(Actividad actividad,Long id) {

        Optional<Evento> opt = repositoryEvento.findById(id);

        Evento evento = opt.isPresent() ? opt.get() : null;
        if( evento != null){
            actividad.setEvento( evento );
            evento.addActividad( actividad );

            return repositoryActividad.save( actividad );
        }

        return null;
    }


}
