package com.viajesCompartidos.viajesCompartidos.controllers;

import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import com.viajesCompartidos.viajesCompartidos.dto.ConductorDto;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioDto;
import com.viajesCompartidos.viajesCompartidos.dto.ViajeInDTO;
import com.viajesCompartidos.viajesCompartidos.services.ConductorService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping
    public List<ConductorDto> getConductores(){
        return conductorService.getConductores();
    }

    @GetMapping("/{id}")
    public ConductorDto getConductorById(@PathVariable Long id){
        return conductorService.getConductorById(id);
    }

    @PostMapping("/{id}/viajes")
    public ResponseEntity<Object> crearNuevoViaje(@PathVariable Long id, @RequestBody ViajeInDTO viajeInDto){
        return conductorService.crearNuevoViaje(viajeInDto, id);
    }

}
