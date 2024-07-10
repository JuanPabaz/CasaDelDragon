package com.got.casaDragon.models;

public class Aliado {

    private Integer idAliado;
    private String nombreAliado;
    private String ubicacion;
    private Double aporte;

    public Aliado() {
    }

    public Aliado(Integer idAliado, String nombreAliado, String ubicacion, Double aporte) {
        this.idAliado = idAliado;
        this.nombreAliado = nombreAliado;
        this.ubicacion = ubicacion;
        this.aporte = aporte;
    }

    public Integer getIdAliado() {
        return idAliado;
    }

    public void setIdAliado(Integer idAliado) {
        this.idAliado = idAliado;
    }

    public String getNombreAliado() {
        return nombreAliado;
    }

    public void setNombreAliado(String nombreAliado) {
        this.nombreAliado = nombreAliado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getAporte() {
        return aporte;
    }

    public void setAporte(Double aporte) {
        this.aporte = aporte;
    }
}
