package com.viajesCompartidos.viajesCompartidos.dto;

import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class UsuarioSinConductorDTO {
    private Long id;
    private String email;
    private String nombre;
    private String apellido;
    private String userName;
    private boolean isDriver;

    public UsuarioSinConductorDTO(Usuario usuario){
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.userName = usuario.getUsername();
        this.isDriver = usuario.isDriver();
    }
}
