package com.seu.projeto.condominio.service;

import com.seu.projeto.condominio.model.Reclamacao;
import com.seu.projeto.condominio.repository.ReclamacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamacaoService {

    @Autowired
    private ReclamacaoRepository reclamacaoRepository;

    public List<Reclamacao> listarTodas() {
        return reclamacaoRepository.findAll();
    }

    public Optional<Reclamacao> buscarPorId(Integer id) {
        return reclamacaoRepository.findById(id);
    }

    public Reclamacao salvar(Reclamacao reclamacao) {
        return reclamacaoRepository.save(reclamacao);
    }

    public void deletar(Integer id) {
        reclamacaoRepository.deleteById(id);
    }
}
