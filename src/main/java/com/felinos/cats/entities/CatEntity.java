package com.felinos.cats.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "gatos")
@Entity
public class CatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String especie;

    @Column
    private String corPelagem;

    @Column
    private String nome;

    @Column
    private Integer idade;
}
