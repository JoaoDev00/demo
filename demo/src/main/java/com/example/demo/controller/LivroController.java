package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*; // Importa as anotações do Spring
import com.example.demo.model.LivroModel;
import com.example.demo.repository.LivroRepository;

@RestController // 1. Diz que esta classe é um controlador REST
@RequestMapping("/livros") // 2. Mapeia as requisições para /livros
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository repository) {
        this.livroRepository = repository;
    }

    @GetMapping // 3. Diz que este método responde ao GET do Insomnia
    public List<LivroModel> listarTodos() {
        return livroRepository.findAll();
    }

    @PostMapping // 4. Diz que este método responde ao POST do Insomnia
    public LivroModel cadastrar(@RequestBody LivroModel livro) { // 5. @RequestBody é vital para ler o JSON
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}") // 6. Diz que este método responde ao PUT do Insomnia
    public LivroModel atualizar(@PathVariable Long id, @RequestBody LivroModel livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            // Adicione aqui os outros campos que quiser atualizar
            return livroRepository.save(livro);
        }).orElseThrow();
    }

    // Deletar um livro
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }
}