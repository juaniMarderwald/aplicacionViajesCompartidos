package com.viajesCompartidos.viajesCompartidos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ViajeInDTO {
    private String ciudadInicio;
    private String ciudadDestino;
    private LocalDate horaSalida;
    private Integer lugaresDisponibles;
    private boolean aceptaMascotas;
}
