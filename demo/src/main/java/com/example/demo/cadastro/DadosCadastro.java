package com.example.demo.cadastro;

public class DadosCadastro {

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private TipoPessoa tipoPessoa;
}

public DadosCadastro() {
}

    public DadosCadastro(String nome, String email, String senha, String telefone, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }
