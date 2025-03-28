package com.seu.projeto.condominio.controller;

import com.seu.projeto.condominio.model.Reserva;
import com.seu.projeto.condominio.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva cadastrarReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
