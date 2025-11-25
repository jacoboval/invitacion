package com.javasystems.invitacion.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "listaInvitados")
public class listaInvitados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAcompanantes() {
        return acompanantes;
    }

    public void setAcompanantes(Integer acompanantes) {
        this.acompanantes = acompanantes;
    }

    private Integer acompanantes;

    //private String tokeAcceso;

    /*
    public String getTokeAcceso() {
        return tokeAcceso;
    }

    public void setTokeAcceso(String tokeAcceso) {
        this.tokeAcceso = tokeAcceso;
    }*/
}
