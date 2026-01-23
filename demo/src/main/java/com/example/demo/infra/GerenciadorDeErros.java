package com.example.demo.infra; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class GerenciadorDeErros {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity tratarErroDeNegocio(RuntimeException ex) {
        // Retorna um JSON limpo para o futuro Frontend
        return ResponseEntity.badRequest().body(Map.of("mensagem", ex.getMessage()));
    }
}