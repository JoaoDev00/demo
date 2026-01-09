package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LivroModel;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
