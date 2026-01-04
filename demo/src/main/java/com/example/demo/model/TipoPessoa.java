package com.example.demo.model;

import com.example.demo.cadastro.DadosCadastro;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tipo_pessoa")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoPessoa {

    @Id
    @GeneratedValue(strategy = GeneratedValue.IDENTITY)

    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING);
    private PessoaModel pessoaModel;

    public PessoaModel(DadosCadastro dados) {
        this.nome = dados.getNome();
        this.email = dados.getEmail();
        this.telefone = dados.getTelefone();
        this.tipoPessoa = dados.getTipoPessoa();
    }

}
