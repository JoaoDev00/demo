package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PessoaModel;
import com.example.demo.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoalmodel criarPessoa(PessoaModel pessoa){
        return pessoaRepository.save(pessoa);
    }
}
