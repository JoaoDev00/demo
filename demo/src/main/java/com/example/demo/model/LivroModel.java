package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "livro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private String isbn;

    private String editora;

    private Integer anoPublicacao;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;
}
