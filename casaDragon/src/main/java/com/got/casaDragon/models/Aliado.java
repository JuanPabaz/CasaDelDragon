package com.got.casaDragon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aliado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAliado;

    @Column(name = "nombre_aliado")
    private String nombreAliado;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "aporte")
    private Double aporte;

    @ManyToOne
    @JoinColumn(name = "idJinete",referencedColumnName = "id_jinete")
    @JsonBackReference
    private Jinete jinete;
}
