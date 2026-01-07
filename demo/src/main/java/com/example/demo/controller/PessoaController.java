package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cadastro.DadosCadastro;
import com.example.demo.model.UsuarioModel;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public UsuarioModel cadastrarPessoa(@RequestBody DadosCadastro dados) {
        UsuarioModel pessoa = new UsuarioModel(dados.nome(), dados.email(), dados.senha(), dados.telefone(), dados.tipoPessoa());
        return pessoaService.criarPessoa(pessoa);
    }

    @GetMapping
    public List<UsuarioModel> listar() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public UsuarioModel buscarPorId(@PathVariable Long id) {
        return pessoaService.consultarPessoa(id);
    }

    @PutMapping("/{id}")
    public UsuarioModel atualizar(@PathVariable Long id, @RequestBody DadosCadastro dados) {
        UsuarioModel pessoa = new UsuarioModel(dados.nome(), dados.email(), dados.senha(), dados.telefone(), dados.tipoPessoa());
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
    }
}