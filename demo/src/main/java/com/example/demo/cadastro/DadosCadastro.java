package com.example.demo.cadastro;

import com.example.demo.model.TipoPessoa;

public record DadosCadastro(
    String nome, 
    String email, 
    String senha, 
    String telefone, 
    TipoPessoa tipoPessoa
) {}