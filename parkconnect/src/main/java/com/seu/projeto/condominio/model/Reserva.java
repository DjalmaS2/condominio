package com.seu.projeto.condominio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @NotNull(message = "Data da reserva é obrigatória")
    @Temporal(TemporalType.DATE)
    private Date dataReserva;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo de reserva é obrigatório")
    private TipoReserva reserva;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status da reserva é obrigatório")
    private StatusReserva statusReserva;

    @ManyToOne
    @JoinColumn(name = "pessoa_idpessoa", nullable = false)
    private Pessoa pessoa;
}
