package com.theuniverse.theuniverse.pagamento.repository;

import com.theuniverse.theuniverse.pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {}
