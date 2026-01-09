package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.LivroModel;
import com.example.demo.service.LivroRepository;

public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository repository) {
        this.livroRepository = repository;
    }

    public List<LivroModel> listarTodos(){
        return livroRepository.findAll()
    }

    public LivroModel cadastrar(LivroModel livro) {
        return livroRepository.save(livro);
    }

}
