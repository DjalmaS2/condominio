package com.seu.projeto.condominio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Corrige a estratégia de herança
@Getter
@Setter
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpessoa;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 90)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private char sexo;

    @Column(nullable = true, length = 255)
    private String fotoPerfil;
}
