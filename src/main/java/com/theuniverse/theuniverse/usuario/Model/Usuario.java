package com.theuniverse.theuniverse.usuario.Model;

import com.theuniverse.theuniverse.usuario.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "USUARIO")
@Table(name = "USUARIO")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "tipo")
    private TipoUsuario tipo = TipoUsuario.CLIENTE;

}
