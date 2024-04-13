package com.github.gustavosthel.authapi.dtos;

public record UsuarioDto(
        String nome,
        String login,
        String senha
) {
}
