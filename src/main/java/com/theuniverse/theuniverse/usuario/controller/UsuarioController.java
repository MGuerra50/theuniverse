package com.theuniverse.theuniverse.usuario.controller;

import com.theuniverse.theuniverse.usuario.DTO.UsuarioDTO;
import com.theuniverse.theuniverse.usuario.Model.Usuario;
import com.theuniverse.theuniverse.usuario.Repository.UsuarioRepository;
import com.theuniverse.theuniverse.usuario.service.UsuarioService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodosUsuarios(){
        var listaUsuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(listaUsuarios);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable("id") Long id){
        return usuarioService.buscandoUsuarioPorId(id);
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> buscarPorEmail(@PathVariable("email") String email){
        return usuarioService.buscandoUsuarioPorEmail(email);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/atualizarUsuario")
    public Usuario atualizandoUsuario (@RequestBody Usuario usuarioAtualizado){
        return usuarioRepository.save(usuarioAtualizado);
    }

}
