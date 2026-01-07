package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public UsuarioModel criarPessoa(UsuarioModel pessoa){
        return pessoaRepository.save(pessoa);
    }

    public UsuarioModel consultarPessoa(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<UsuarioModel> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public UsuarioModel atualizarPessoa(Long id, UsuarioModel pessoa) {
        if (!pessoaRepository.existsById(id)) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        pessoa.setId(id);
        return pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        pessoaRepository.deleteById(id);
    }
}