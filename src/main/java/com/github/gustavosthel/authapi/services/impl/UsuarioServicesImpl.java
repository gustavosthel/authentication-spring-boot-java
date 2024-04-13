package com.github.gustavosthel.authapi.services.impl;

import com.github.gustavosthel.authapi.dtos.UsuarioDto;
import com.github.gustavosthel.authapi.models.Usuario;
import com.github.gustavosthel.authapi.repositories.UsuarioRepositories;
import com.github.gustavosthel.authapi.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    private UsuarioRepositories usuarioRepositories;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario usuarioJaExiste = usuarioRepositories.findByLogin(usuarioDto.login());

        if (usuarioJaExiste != null) {
            throw new RuntimeException("Usuario já existe!");
        }

        Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.login(), usuarioDto.senha());
        Usuario novoUsuario = usuarioRepositories.save(entity);
        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(), novoUsuario.getSenha());
    }
}
