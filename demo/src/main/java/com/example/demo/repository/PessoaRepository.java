package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}