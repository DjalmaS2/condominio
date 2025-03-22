package com.seu.projeto.condominio.controller;

import com.seu.projeto.condominio.model.Usuario;
import com.seu.projeto.condominio.security.JwtUtil;
import com.seu.projeto.condominio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);

        if (usuario.isPresent() && passwordEncoder.matches(senha, usuario.get().getSenha())) {
            String token = jwtUtil.generateToken(email);
            return "Token: " + token;
        }
        return "Credenciais inválidas.";
    }
}
