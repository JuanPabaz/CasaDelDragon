package com.got.casaDragon.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dragon")
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDragon;
    private String nombreDragon;
    private Integer edad;
    private Double altura;
    private Integer numeroVictorias;

    public Dragon() {
    }

    public Dragon(Integer idDragon, String nombreDragon, Integer edad, Double altura, Integer numeroVictorias) {
        this.idDragon = idDragon;
        this.nombreDragon = nombreDragon;
        this.edad = edad;
        this.altura = altura;
        this.numeroVictorias = numeroVictorias;
    }

    public Integer getIdDragon() {
        return idDragon;
    }

    public void setIdDragon(Integer idDragon) {
        this.idDragon = idDragon;
    }

    public String getNombreDragon() {
        return nombreDragon;
    }

    public void setNombreDragon(String nombreDragon) {
        this.nombreDragon = nombreDragon;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(Integer numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }
}
