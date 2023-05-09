package com.viajesCompartidos.viajesCompartidos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ConductorInDTO {
    private double reputacion;
    private String licenciaDeConducir;
}
