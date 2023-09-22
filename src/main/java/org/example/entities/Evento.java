package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvento;

    @Column(name = "name_evento")
    private String nameEvento;

    @Column(name = "fecha_evento")
    private LocalDate fechaEvento;

    @Column(name = "tipoEvento")
    private String tipoEvento;

    @OneToMany(mappedBy = "evento")
    @JsonIgnore
    private List<Actividad> actividades;


    public Evento(){
        actividades = new ArrayList<>();
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNameEvento() {
        return nameEvento;
    }

    public void setNameEvento(String nameEvento) {
        this.nameEvento = nameEvento;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void addActividad(Actividad actividad){
        actividades.add(actividad);
    }
}