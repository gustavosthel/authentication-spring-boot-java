package com.github.gustavosthel.authapi.services.impl;

import com.github.gustavosthel.authapi.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoServicesImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositories usuarioRepositories;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepositories.findByLogin(login);
    }
}
