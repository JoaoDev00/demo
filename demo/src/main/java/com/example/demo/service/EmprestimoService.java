package com.example.demo.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.example.demo.model.EmprestimoModel;
import com.example.demo.model.LivroModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.model.StatusLivro;
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

    // MÉTODO PARA PEGAR LIVRO
    public EmprestimoModel realizarEmprestimo(Long livroID, Long pessoaID) {
        LivroModel livro = livroRepository.findById(livroID)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + livroID));

        UsuarioModel pessoa = pessoaRepository.findById(pessoaID)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + pessoaID));

        if (livro.getStatus() != StatusLivro.DISPONIVEL) {
            throw new RuntimeException("Este livro já está emprestado no momento.");
        }

        livro.setStatus(StatusLivro.EMPRESTADO);
        livroRepository.save(livro);

        EmprestimoModel emprestimo = new EmprestimoModel();
        emprestimo.setLivro(livro);
        emprestimo.setPessoa(pessoa);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(7));

        return emprestimoRepository.save(emprestimo);
    }

    // MÉTODO PARA DEVOLVER LIVRO
    public EmprestimoModel devolverLivro(Long emprestimoID) {
        EmprestimoModel emprestimo = emprestimoRepository.findById(emprestimoID)
                .orElseThrow(() -> new RuntimeException("Registro de empréstimo não encontrado."));

        LivroModel livro = emprestimo.getLivro();
        livro.setStatus(StatusLivro.DISPONIVEL);
        livroRepository.save(livro);

        // Atualiza a data de devolução para o dia real da entrega
        emprestimo.setDataDevolucao(LocalDate.now());

        return emprestimoRepository.save(emprestimo);
    }
}