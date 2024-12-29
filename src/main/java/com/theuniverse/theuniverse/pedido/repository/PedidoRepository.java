package com.theuniverse.theuniverse.pedido.repository;

import com.theuniverse.theuniverse.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
