package com.seu.projeto.condominio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Reclamacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReclamacao;

    @NotBlank(message = "Descrição da reclamação é obrigatória")
    @Column(columnDefinition = "LONGTEXT")
    private String reclamacao;

    @NotNull(message = "Data de envio é obrigatória")
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status da reclamação é obrigatório")
    private StatusReclamacao statusReclamacao;

    @ManyToOne
    @JoinColumn(name = "pessoa_idpessoa", nullable = false)
    private Pessoa pessoa;
}
