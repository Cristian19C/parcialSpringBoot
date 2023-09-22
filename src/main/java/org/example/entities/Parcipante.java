package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "participantes")
public class Parcipante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParcipante;

    @Column(name = "name_parcipante")
    private String nameParcipante;

    @Column(name = "tipo_parcipante")
    private String tipoParcipante;
}
