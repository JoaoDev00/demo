package com.example.demo.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.example.demo.model.EmprestimoModel;
import com.example.demo.model.LivroModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.model.StatusLivro; // Importe o seu Enum
import com.example.demo.repository.EmprestimoRepository;
import com.example.demo.repository.LivroRepository;
import com.example.demo.repository.PessoaRepository;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final PessoaRepository pessoaRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, 
                             LivroRepository livroRepository,
                             PessoaRepository pessoaRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public EmprestimoModel realizarEmprestimo(Long livroID, Long pessoaID) {
        LivroModel livro = livroRepository.findById(livroID)
                .orElseThrow(() -> new RuntimeException("Livro nao encontrado"));

        UsuarioModel pessoa = pessoaRepository.findById(pessoaID)
                .orElseThrow(() -> new RuntimeException("Pessoa nao encontrada"));

        // CORREÇÃO: Compara usando o Enum diretamente
        if (livro.getStatus() != StatusLivro.DISPONIVEL) {
            throw new RuntimeException("Livro nao disponivel para emprestimo");
        }

        // CORREÇÃO: Seta o status usando o Enum
        livro.setStatus(StatusLivro.EMPRESTADO);
        livroRepository.save(livro);

        EmprestimoModel emprestimo = new EmprestimoModel();
        emprestimo.setLivro(livro);
        emprestimo.setPessoa(pessoa);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(7));

        return emprestimoRepository.save(emprestimo);
    }
}