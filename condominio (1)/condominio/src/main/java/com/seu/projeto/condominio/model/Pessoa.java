package com.seu.projeto.condominio.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String sexo;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Morador morador;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Sindico sindico;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    // Getters e Setters
}
