package com.viajesCompartidos.viajesCompartidos.dto;

import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ConductorDto {
    private Long id;
    private String username;
    private String name;
    private String apellido;
    private double reputacion;
    private String licenciaDeConducir;
    private Set<ViajeSinConductorDTO> viajes = new HashSet<>();
/*
    private AutoDto auto;
*/

    public ConductorDto(Conductor conductor) {
        this.id=conductor.getId();
        this.reputacion=conductor.getReputacion();
        this.licenciaDeConducir=conductor.getLicenciaDeConducir();
        this.username = conductor.getUsuario().getUsername();
        this.name= conductor.getUsuario().getNombre();
        this.apellido=conductor.getUsuario().getApellido();
        this.viajes=conductor.getViajes().stream().map(ViajeSinConductorDTO::new).collect(Collectors.toSet());
/*
        this.auto=new AutoDto(conductor.getVehiculo());
*/
    }
}
