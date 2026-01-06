package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cadastro.DadosCadastro;
import com.example.demo.model.PessoaModel;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaModel cadastrarPessoa(@RequestBody DadosCadastro dados) {
        PessoaModel pessoa = new PessoaModel(dados.nome(), dados.email(), dados.senha(), dados.telefone(), dados.tipoPessoa());
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
    public PessoaModel atualizar(@PathVariable Long id, @RequestBody DadosCadastro dados) {
        PessoaModel pessoa = new PessoaModel(dados.nome(), dados.email(), dados.senha(), dados.telefone(), dados.tipoPessoa());
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }
}