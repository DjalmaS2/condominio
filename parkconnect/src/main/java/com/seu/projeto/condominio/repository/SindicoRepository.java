package com.seu.projeto.condominio.repository;

import com.seu.projeto.condominio.model.Sindico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SindicoRepository extends JpaRepository<Sindico, Integer> {
    Sindico findByEmailsindico(String email);
}
