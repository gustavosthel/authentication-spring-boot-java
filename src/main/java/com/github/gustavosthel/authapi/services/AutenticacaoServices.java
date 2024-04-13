package com.github.gustavosthel.authapi.services;

import com.github.gustavosthel.authapi.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutenticacaoServices extends UserDetailsService {

    public String obterToken(AuthDto authDto);

    public String validaTokenJwt(String token);
}
