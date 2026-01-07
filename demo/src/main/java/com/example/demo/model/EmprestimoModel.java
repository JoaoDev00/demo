package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

public class EmprestimoModel {

    private Long id;

    private LivroModel livro;

    private UsuarioModel usuario;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucaoPrevista;

    private LocalDate dataDevolucaoReal;
}