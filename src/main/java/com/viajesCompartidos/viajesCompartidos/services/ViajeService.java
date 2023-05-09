package com.viajesCompartidos.viajesCompartidos.services;

import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import com.viajesCompartidos.viajesCompartidos.dto.ViajeConductorDTO;
import com.viajesCompartidos.viajesCompartidos.dto.ViajeDTO;
import com.viajesCompartidos.viajesCompartidos.exceptions.ViajesCompartidosExceptions;
import com.viajesCompartidos.viajesCompartidos.repositories.ViajeRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ViajeService {
    private final ViajeRepository viajeRepository;

    public ViajeService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    public List<ViajeConductorDTO> getTodosLosViajes(){
        return viajeRepository.findAll().stream().map(ViajeConductorDTO::new).collect(Collectors.toList());
    }

    public ViajeConductorDTO getViajeById(Long id){
        Optional<Viaje> viajeOptional = viajeRepository.findById(id);
        if(viajeOptional.isEmpty()){
            throw new ViajesCompartidosExceptions("El viaje con id: "+id+" No existe", HttpStatus.NOT_FOUND);
        }else{
          return new ViajeConductorDTO(viajeOptional.get());
        }
    }


}
