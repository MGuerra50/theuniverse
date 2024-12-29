package com.theuniverse.theuniverse.pagamento.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "pagamento")
@Table(name = "pagamento")
@EqualsAndHashCode(of = "{id}")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pepeido_id")
    private Long pepido_id;
    @Column(name = "data_pagamento")
    private Date data_pagamento;
    @Column(name = "valor_pago")
    private Float valor_pago;
    @Column(name = "metodo")
    private String metodo;
    @Column(name = "status")
    private String status;
}
