package com.viajesCompartidos.viajesCompartidos.mappers;

import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import com.viajesCompartidos.viajesCompartidos.dto.ConductorInDTO;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioInDTO;
import org.springframework.stereotype.Component;

@Component
public class ConductorDtoToConductorMapper implements IMapper<ConductorInDTO, Conductor>{
    @Override
    public Conductor map(ConductorInDTO in) {
        Conductor conductor = new Conductor();
        conductor.setReputacion(in.getReputacion());
        conductor.setLicenciaDeConducir(in.getLicenciaDeConducir());
        return conductor;
    }
}
