package com.theuniverse.theuniverse.pedido.controller;

import com.theuniverse.theuniverse.pedido.model.Pedido;
import com.theuniverse.theuniverse.pedido.repository.PedidoRepository;
import com.theuniverse.theuniverse.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;
    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/listarTodos/{idUsuario}")
    public ResponseEntity<List<Pedido>> obterTodosPedidosDoUsuario (@PathVariable Long idUsuario){
        List<Pedido> verificandoExistenciaPedidos = pedidoRepository.findAll();
        if(verificandoExistenciaPedidos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(verificandoExistenciaPedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> detalhesPedido (@PathVariable Long id){
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(id);
        if(pedidoBuscado.isPresent()){
            Pedido pedidoEncontrado = pedidoBuscado.get();
            return ResponseEntity.ok(pedidoEncontrado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido novoPedido){
        try{
            Pedido salvandoPedido = pedidoRepository.save(novoPedido);
            URI local = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(salvandoPedido.getId())
                    .toUri();
            return ResponseEntity.created(local).body(salvandoPedido);
        } catch (Exception erro){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
