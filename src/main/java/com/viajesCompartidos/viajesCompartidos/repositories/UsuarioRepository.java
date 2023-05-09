package com.viajesCompartidos.viajesCompartidos.repositories;

import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByEmail(String correoElectronico);
    public Optional<Usuario> findByUsername(String username);
}

