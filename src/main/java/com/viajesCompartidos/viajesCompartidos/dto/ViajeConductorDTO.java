package com.viajesCompartidos.viajesCompartidos.dto;

import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Component
public class ViajeConductorDTO {
    private Long id;
    private String ciudadInicio;
    private String ciudadDestino;
    private LocalDate horaSalida;
    private Integer lugaresDisponibles;
    private boolean aceptaMascotas;
    private boolean finished;
    private ConductorSinViajesDTO conductor;
    private List<UsuarioSinConductorDTO> pasajeros;
    public ViajeConductorDTO(Viaje viaje){
        this.id=viaje.getId();
        this.ciudadInicio=viaje.getCiudadInicio();
        this.ciudadDestino=viaje.getCiudadDestino();
        this.horaSalida=viaje.getHoraSalida();
        this.lugaresDisponibles=viaje.getLugaresDisponibles();
        this.aceptaMascotas=viaje.isAceptaMascotas();
        this.finished=viaje.isFinished();
        this.conductor =new ConductorSinViajesDTO(viaje.getConductor());
        this.pasajeros=viaje.getPasajeros().stream().map(UsuarioSinConductorDTO::new).collect(Collectors.toList());
    }
}
