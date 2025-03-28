package com.seu.projeto.condominio.service;

import com.seu.projeto.condominio.model.Veiculo;
import com.seu.projeto.condominio.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return veiculoRepository.findById(placa);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deletar(String placa) {
        veiculoRepository.deleteById(placa);
    }
}
