package org.example.repositories;

import org.example.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEvento extends JpaRepository<Evento, Long> {
}
