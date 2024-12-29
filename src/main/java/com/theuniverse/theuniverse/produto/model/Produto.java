package com.theuniverse.theuniverse.produto.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "PRODUTO")
@Table(name = "PRODUTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "categoria_id")
    private Long categoria_id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private Float preco;
    @Column(name = "estoque")
    private Long estoque;

}
