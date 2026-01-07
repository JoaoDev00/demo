package com.example.demo.model;

import java.time.LocalDate;

public class EmprestimoModel {

    Long id;

    private LivroModel livro;

    private UsuarioModel usuario;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucaoPrevista;

    private LocalDate dataDevolucaoReal;
}
