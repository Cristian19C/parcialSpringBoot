package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    private String id;

    @Column(name = "name_actividad")
    private String nameActividad;

    @Column(name = "tipo_actividad")
    private String tipoActividad;


    @ManyToOne
    @JoinColumn(name = "ref_evento", nullable = false)
    private Evento evento;

    public Actividad() {
    }

    public Actividad(String id, String nameActividad, String tipoActividad) {
        this.id = id;
        this.nameActividad = nameActividad;
        this.tipoActividad = tipoActividad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameActividad() {
        return nameActividad;
    }

    public void setNameActividad(String nameActividad) {
        this.nameActividad = nameActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", nameActividad='" + nameActividad + '\'' +
                ", tipoActividad='" + tipoActividad + '\'' +
                ", evento=" + evento +
                '}';
    }
}
