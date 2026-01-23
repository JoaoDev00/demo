package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.EmprestimoModel;
import com.example.demo.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    // Injeção de dependência pelo construtor
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/realizar/{livroId}/{pessoaId}")
    public EmprestimoModel realizar(@PathVariable Long livroId, @PathVariable Long pessoaId) {
        return emprestimoService.realizarEmprestimo(livroId, pessoaId);
    }

    @PostMapping("/devolver/{emprestimoId}")
    public EmprestimoModel devolver(@PathVariable Long emprestimoId) {
        return emprestimoService.devolverLivro(emprestimoId);
    }
}