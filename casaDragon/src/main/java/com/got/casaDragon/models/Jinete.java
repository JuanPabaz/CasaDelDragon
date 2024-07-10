package com.got.casaDragon.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "jinete")
public class Jinete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJinete;

    @Column(name = "nombre_jinete")
    private String nombreJinete;

    @Column(name = "edad_jinete")
    private Integer edadJinete;

    @Column(name = "fecha_montura")
    private LocalDate fechaMontura;

    public Jinete() {
    }

    public Jinete(Integer idJinete, String nombreJinete, Integer edadJinete, LocalDate fechaMontura) {
        this.idJinete = idJinete;
        this.nombreJinete = nombreJinete;
        this.edadJinete = edadJinete;
        this.fechaMontura = fechaMontura;
    }

    public Integer getIdJinete() {
        return idJinete;
    }

    public void setIdJinete(Integer idJinete) {
        this.idJinete = idJinete;
    }

    public String getNombreJinete() {
        return nombreJinete;
    }

    public void setNombreJinete(String nombreJinete) {
        this.nombreJinete = nombreJinete;
    }

    public Integer getEdadJinete() {
        return edadJinete;
    }

    public void setEdadJinete(Integer edadJinete) {
        this.edadJinete = edadJinete;
    }

    public LocalDate getFechaMontura() {
        return fechaMontura;
    }

    public void setFechaMontura(LocalDate fechaMontura) {
        this.fechaMontura = fechaMontura;
    }
}
