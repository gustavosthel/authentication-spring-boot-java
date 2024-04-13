package com.github.gustavosthel.authapi.controllers;

import com.github.gustavosthel.authapi.dtos.UsuarioDto;
import com.github.gustavosthel.authapi.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {

    @Autowired
    private UsuarioServices usuarioService;

    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.salvar(usuarioDto);
    }

    @GetMapping
    private String getOk(){
        return "Ok";
    }
}

