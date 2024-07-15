package com.got.casaDragon.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jinete")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jinete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jinete")
    private Integer idJinete;

    @Column(name = "nombre_jinete")
    private String nombreJinete;

    @Column(name = "edad_jinete")
    private Integer edadJinete;

    @Column(name = "fecha_montura")
    private LocalDate fechaMontura;

    @OneToMany(mappedBy = "jinete")
    @JsonManagedReference
    private List<Dragon> dragones;

    @OneToMany(mappedBy = "jinete")
    @JsonManagedReference
    private List<Aliado> aliados;

}
