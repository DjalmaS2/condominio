package com.seu.projeto.condominio.repository;

import com.seu.projeto.condominio.model.Reclamacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Integer> {
}
