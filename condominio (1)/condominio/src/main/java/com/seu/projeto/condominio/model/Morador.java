package com.seu.projeto.condominio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "morador")
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMorador;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String bloco;

    @Column(nullable = false)
    private Integer apartamento;

    @OneToOne
    @JoinColumn(name = "pessoa_idpessoa", nullable = false)
    private Pessoa pessoa;

    // Getters e Setters
}
