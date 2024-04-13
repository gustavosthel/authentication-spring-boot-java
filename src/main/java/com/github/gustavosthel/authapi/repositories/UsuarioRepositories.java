package com.github.gustavosthel.authapi.repositories;

import com.github.gustavosthel.authapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {
}
