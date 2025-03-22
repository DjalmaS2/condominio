package com.seu.projeto.condominio.model;

import jakarta.persistence.*;

@Entity
public class Sindico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;

    // Getters e Setters
}
