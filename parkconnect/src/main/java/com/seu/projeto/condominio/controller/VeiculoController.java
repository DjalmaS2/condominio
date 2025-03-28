package com.seu.projeto.condominio.controller;

import com.seu.projeto.condominio.model.Veiculo;
import com.seu.projeto.condominio.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    @PostMapping
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @DeleteMapping("/{placa}")
    public void deletarVeiculo(@PathVariable String placa) {
        veiculoRepository.deleteById(placa);
    }
}
