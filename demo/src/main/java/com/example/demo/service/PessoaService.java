package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PessoaModel;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel criarPessoa(PessoaModel pessoa){
        return pessoaRepository.save(pessoa);
    }

    public PessoaModel consultarPessoa(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<PessoaModel> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public PessoaModel atualizarPessoa(Long id, PessoaModel pessoa) {
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