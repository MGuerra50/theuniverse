package com.theuniverse.theuniverse.categoria.service;

import com.theuniverse.theuniverse.categoria.model.Categoria;
import com.theuniverse.theuniverse.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> bucarTodas() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscandoPorId(Long id) {
        return categoriaRepository.findById(id);
    }
}
