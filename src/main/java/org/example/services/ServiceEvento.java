package org.example.services;

import org.example.entities.Evento;
import org.example.repositories.RepositoryEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEvento {

    @Autowired
    private RepositoryEvento repositoryEvento;

    public List<Evento> findAll(){

        return repositoryEvento.findAll();
    }

    public Evento findById( Long id ){

        Optional<Evento> opt = repositoryEvento.findById(id);

        return opt.isPresent() ? opt.get() : null;
    }

    public Evento save( Evento evento){

        return repositoryEvento.save( evento );
    }
}
