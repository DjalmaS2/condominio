package com.seu.projeto.condominio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Veiculo {

    @Id
    @NotBlank(message = "Placa do veículo é obrigatória")
    private String placa;

    @NotBlank(message = "Modelo do veículo é obrigatório")
    private String modelo;

    @NotBlank(message = "Cor do veículo é obrigatória")
    private String cor;

    @ManyToOne
    @JoinColumn(name = "pessoa_idpessoa", nullable = false)
    private Pessoa pessoa;
}
