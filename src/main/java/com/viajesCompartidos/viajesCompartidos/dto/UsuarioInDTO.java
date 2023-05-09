package com.viajesCompartidos.viajesCompartidos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UsuarioInDTO {
    private String email;
    private String nombre;
    private String apellido;
    private String userName;
    private String password;
    private boolean isDriver;
    private ConductorInDTO conductor;

}
