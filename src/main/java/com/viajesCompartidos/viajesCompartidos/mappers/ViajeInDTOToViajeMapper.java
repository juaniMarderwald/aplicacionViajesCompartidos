package com.viajesCompartidos.viajesCompartidos.mappers;

import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import com.viajesCompartidos.viajesCompartidos.dto.ViajeInDTO;
import org.springframework.stereotype.Component;

@Component
public class ViajeInDTOToViajeMapper implements IMapper<ViajeInDTO, Viaje>{
    @Override
    public Viaje map(ViajeInDTO in) {
        Viaje viaje = new Viaje();
        viaje.setCiudadInicio(in.getCiudadInicio());
        viaje.setCiudadDestino(in.getCiudadDestino());
        viaje.setHoraSalida(in.getHoraSalida());
        viaje.setLugaresDisponibles(in.getLugaresDisponibles());
        viaje.setAceptaMascotas(in.isAceptaMascotas());
        viaje.setFinished(false);
        return viaje;
    }
}
