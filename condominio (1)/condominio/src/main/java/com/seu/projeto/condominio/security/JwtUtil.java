package com.seu.projeto.condominio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "sua_chave_secreta"; // Troque por uma chave segura
    private static final long EXPIRATION_TIME = 86400000; // 1 dia

    // Gerar Token JWT
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validar Token JWT
    public boolean validateToken(String token, String email) {
        return (email.equals(extractUsername(token)) && !isTokenExpired(token));
    }

    // Extrair usuário (email) do token
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Verificar se o token expirou
    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // Extrair as informações do token
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
