package com.got.casaDragon.models;

import java.time.LocalDate;

public class Jinete {

    private Integer idJinete;
    private String nombreJinete;
    private Integer edadJinete;
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
