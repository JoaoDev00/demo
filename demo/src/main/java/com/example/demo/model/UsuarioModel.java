package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "pessoa")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    public UsuarioModel(String nome, String email, String senha, String telefone, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }
}