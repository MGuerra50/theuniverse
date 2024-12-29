package com.theuniverse.theuniverse.usuario.service;

import com.theuniverse.theuniverse.usuario.Model.Usuario;
import com.theuniverse.theuniverse.usuario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String testando (){
        return "Teste Service bem sucedido!";
    }

    public Optional<Usuario> buscandoUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscandoUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
