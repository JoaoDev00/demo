package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EmprestimoModel;

public interface EmprestimoRepository extends JpaRepository< EmprestimoModel, Long >{
}