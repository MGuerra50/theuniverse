package com.theuniverse.theuniverse.pedido.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "pedido")
@Table(name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario_id")
    private Long usuario_id;
    @Column(name = "data_pedido")
    private Date data_pedido;
    @Column(name = "status")
    private String status;
    @Column(name = "total")
    private Float total;
}
