package com.viajesCompartidos.viajesCompartidos.controllers;

import com.viajesCompartidos.viajesCompartidos.dto.ViajeConductorDTO;
import com.viajesCompartidos.viajesCompartidos.dto.ViajeDTO;
import com.viajesCompartidos.viajesCompartidos.repositories.ViajeRepository;
import com.viajesCompartidos.viajesCompartidos.services.ViajeService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/viajes")
public class ViajeController {
    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public List<ViajeConductorDTO> getTodosLosViajes(){
        return viajeService.getTodosLosViajes();
    }

    @GetMapping("/{id}")
    public ViajeConductorDTO getViajeById(@PathVariable Long id){
        return viajeService.getViajeById(id);
    }

}
