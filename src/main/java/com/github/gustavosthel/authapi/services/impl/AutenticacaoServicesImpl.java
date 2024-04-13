package com.github.gustavosthel.authapi.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.github.gustavosthel.authapi.dtos.AuthDto;
import com.github.gustavosthel.authapi.models.Usuario;
import com.github.gustavosthel.authapi.repositories.UsuarioRepositories;
import com.github.gustavosthel.authapi.services.AutenticacaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AutenticacaoServicesImpl implements AutenticacaoServices {

    @Autowired
    private UsuarioRepositories usuarioRepositories;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepositories.findByLogin(login);
    }

    @Override
    public String obterToken(AuthDto authDto) {
        Usuario usuario = usuarioRepositories.findByLogin(authDto.login());
        return geraTokenJwt(usuario);
    }

    public String geraTokenJwt(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("my-secret");

            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(geraDataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token" + exception.getMessage());
        }
    }

    private Instant geraDataExpiracao() {
        return LocalDateTime.now()
               .plusHours(8)
               .toInstant(ZoneOffset.of("-03:00"));
    }
}
