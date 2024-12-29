package com.theuniverse.theuniverse.categoria.controller;

import com.theuniverse.theuniverse.categoria.model.Categoria;
import com.theuniverse.theuniverse.categoria.repository.CategoriaRepository;
import com.theuniverse.theuniverse.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarTodasCategorias (){
        return categoriaService.bucarTodas();
    }

    @PostMapping
    public Categoria adicionarCategoria (@RequestBody Categoria novaCategoria){
        return categoriaRepository.save(novaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizandoCategoria (@PathVariable Long id, @RequestBody Categoria categoriaAtualizada){
        Optional<Categoria> buscandoCategoria = categoriaService.buscandoPorId(id);
        if(buscandoCategoria.isPresent()){
            Categoria categoria = buscandoCategoria.get();
            categoria.setNome(categoriaAtualizada.getNome());
            categoria.setDescricao(categoriaAtualizada.getDescricao());
            categoriaRepository.save(categoria);
            return ResponseEntity.ok(categoria);
        }
        return ResponseEntity.notFound().build();
    }
}
