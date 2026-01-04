package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.cadastro.DadosCadastro;

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping

    public Pessoalmodel cadastrarPessoa(@RequestBody DadosCadastro dados) {
        Pessoalmodel pessoa = new Pessoalmodel();

        return pessoaService.criarPessoa(pessoa);
    }

    @GetMapping
    public List<PessoaModel> listar() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public PessoaModel buscarPorId(@PathVariable Long id) {
        return pessoaService.consultarPessoa(id);
    }

    @PutMapping("/{id}")
    public PessoaModel atualizar(@PathVariable Long id, @RequestBody DadosCadastroPessoa dados) {
        return pessoaService.atualizarPessoa(id, new PessoaModel(dados));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }
}
