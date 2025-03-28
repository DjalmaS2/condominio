package com.seu.projeto.condominio.controller;

import com.seu.projeto.condominio.model.Reclamacao;
import com.seu.projeto.condominio.repository.ReclamacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamacoes")
public class ReclamacaoController {

    @Autowired
    private ReclamacaoRepository reclamacaoRepository;

    @GetMapping
    public List<Reclamacao> listarReclamacoes() {
        return reclamacaoRepository.findAll();
    }

    @PostMapping
    public Reclamacao cadastrarReclamacao(@RequestBody Reclamacao reclamacao) {
        return reclamacaoRepository.save(reclamacao);
    }
}
