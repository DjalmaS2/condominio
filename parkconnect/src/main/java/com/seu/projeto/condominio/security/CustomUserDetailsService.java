package com.seu.projeto.condominio.security;

import com.seu.projeto.condominio.model.Morador;
import com.seu.projeto.condominio.model.Sindico;
import com.seu.projeto.condominio.repository.MoradorRepository;
import com.seu.projeto.condominio.repository.SindicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private SindicoRepository sindicoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Morador morador = moradorRepository.findByEmailmorador(email);
        if (morador != null) {
            return morador;
        }

        Sindico sindico = sindicoRepository.findByEmailsindico(email);
        if (sindico != null) {
            return sindico;
        }

        throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
    }
}
