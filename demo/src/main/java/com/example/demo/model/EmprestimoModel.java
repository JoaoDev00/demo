package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data // Essa anotação cria os sets e gets automaticamente
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Um empréstimo tem um livro
    private LivroModel livro;

    @ManyToOne // Um empréstimo tem uma pessoa/usuário
    private UsuarioModel pessoa;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}