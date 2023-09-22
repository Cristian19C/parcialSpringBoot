package org.example.repositories;

import org.example.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryActividad extends JpaRepository<Actividad, String> {
}
