package com.theuniverse.theuniverse.produto.controller;

import com.theuniverse.theuniverse.produto.model.Produto;
import com.theuniverse.theuniverse.produto.repository.ProdutoRepository;
import com.theuniverse.theuniverse.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodosProdutos (){
        List<Produto> produtosEncontrados = produtoRepository.findAll();
        if(produtosEncontrados.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtosEncontrados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProduto (@PathVariable Long id){
        Optional<Produto> verificaProdutoExiste = produtoRepository.findById(id);
        if(verificaProdutoExiste.isPresent()){
            Produto produto = verificaProdutoExiste.get();
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Produto adicionarProduto (@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizandoProduto (@PathVariable Long id, @RequestBody Produto produto){
        Optional<Produto> verificaProdutoExiste = produtoRepository.findById(id);
        if(verificaProdutoExiste.isPresent()){
            Produto atualizando = verificaProdutoExiste.get();
            atualizando.setCategoria_id(produto.getCategoria_id());
            atualizando.setNome(produto.getNome());
            atualizando.setDescricao(produto.getDescricao());
            atualizando.setPreco(produto.getPreco());
            atualizando.setEstoque(produto.getEstoque());
            produtoRepository.save(atualizando);
            return ResponseEntity.ok(atualizando);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        Optional<Produto> verificaProdutoExiste = produtoRepository.findById(id);
        if(verificaProdutoExiste.isPresent()){
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
