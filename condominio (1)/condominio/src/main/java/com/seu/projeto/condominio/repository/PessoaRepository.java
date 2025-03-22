package com.seu.projeto.condominio.repository;

import com.seu.projeto.condominio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    boolean existsByCpf(String cpf);
}

