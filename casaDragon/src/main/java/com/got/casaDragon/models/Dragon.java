package com.got.casaDragon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dragon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDragon;

    @Column(name = "nombre_dragon")
    private String nombreDragon;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "numero_victorias")
    private Integer numeroVictorias;

    @ManyToOne
    @JoinColumn(name = "idJinete",referencedColumnName = "id_jinete")
    @JsonBackReference
    private Jinete jinete;

}
