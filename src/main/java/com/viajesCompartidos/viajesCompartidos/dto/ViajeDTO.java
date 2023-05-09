package com.viajesCompartidos.viajesCompartidos.dto;

import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Component
public class ViajeDTO {
    private Long id;
    private String ciudadInicio;
    private String ciudadDestino;
    private LocalDate horaSalida;
    private Integer lugaresDisponibles;
    private boolean aceptaMascotas;
    private boolean finished;
    private ConductorSinViajesDTO conductorDTO;
    public ViajeDTO(Viaje viaje){
        this.id=viaje.getId();
        this.ciudadInicio=viaje.getCiudadInicio();
        this.ciudadDestino=viaje.getCiudadDestino();
        this.horaSalida=viaje.getHoraSalida();
        this.lugaresDisponibles=viaje.getLugaresDisponibles();
        this.aceptaMascotas=viaje.isAceptaMascotas();
        this.finished=viaje.isFinished();
        this.conductorDTO= new ConductorSinViajesDTO(viaje.getConductor());
    }
}
