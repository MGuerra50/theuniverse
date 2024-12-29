package com.theuniverse.theuniverse.categoria.repository;

import com.theuniverse.theuniverse.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
