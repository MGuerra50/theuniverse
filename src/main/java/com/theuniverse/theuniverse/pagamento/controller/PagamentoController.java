package com.theuniverse.theuniverse.pagamento.controller;

import com.theuniverse.theuniverse.pagamento.model.Pagamento;
import com.theuniverse.theuniverse.pagamento.repository.PagamentoRepository;
import com.theuniverse.theuniverse.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;
    @Autowired
    PagamentoRepository pagamentoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> informacaoDePagamento (@PathVariable Long id){
        Optional<Pagamento> buscandoPagamento = pagamentoRepository.findById(id);
        if(buscandoPagamento.isPresent()){
            Pagamento pagamento = buscandoPagamento.get();
            return ResponseEntity.ok(pagamento);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pagamento> registrarPagamento (@RequestBody Pagamento pagamento){
        try{
            Pagamento novoPagamento = pagamentoRepository.save(pagamento);
            URI local = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(pagamento.getId())
                    .toUri();
            return ResponseEntity.created(local).body(novoPagamento);
        } catch (Exception erro){
            System.out.println(erro.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
