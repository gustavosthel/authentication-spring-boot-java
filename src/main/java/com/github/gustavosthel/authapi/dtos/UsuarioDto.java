package com.github.gustavosthel.authapi.dtos;

import com.github.gustavosthel.authapi.enums.RoleEnum;

public record UsuarioDto(
        String nome,
        String login,
        String senha,
        RoleEnum role
) {
}
