package com.theuniverse.theuniverse.categoria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "CATEGORIA")
@Table(name = "CATEGORIA")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
}
