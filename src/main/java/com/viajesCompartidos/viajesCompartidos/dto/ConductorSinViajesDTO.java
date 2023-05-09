package com.viajesCompartidos.viajesCompartidos.dto;

import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class ConductorSinViajesDTO {

    private Long id;
    private String username;
    private String name;
    private String apellido;
    private double reputacion;
    private String licenciaDeConducir;

    public ConductorSinViajesDTO(Conductor conductor) {
        this.id=conductor.getId();
        this.reputacion=conductor.getReputacion();
        this.licenciaDeConducir=conductor.getLicenciaDeConducir();
        this.username = conductor.getUsuario().getUsername();
        this.name= conductor.getUsuario().getNombre();
        this.apellido=conductor.getUsuario().getApellido();
    }
}
