package com.viajesCompartidos.viajesCompartidos.services;

import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import com.viajesCompartidos.viajesCompartidos.dto.ConductorDto;
import com.viajesCompartidos.viajesCompartidos.dto.ViajeInDTO;
import com.viajesCompartidos.viajesCompartidos.exceptions.ViajesCompartidosExceptions;
import com.viajesCompartidos.viajesCompartidos.mappers.ViajeInDTOToViajeMapper;
import com.viajesCompartidos.viajesCompartidos.repositories.ConductorRepository;
import com.viajesCompartidos.viajesCompartidos.repositories.ViajeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConductorService {
    private final ConductorRepository conductorRepository;
    private final ViajeInDTOToViajeMapper viajeInDTOToViajeMapper;

    private final ViajeRepository viajeRepository;

    public ConductorService(ConductorRepository conductorRepository, ViajeInDTOToViajeMapper viajeInDTOToViajeMapper, ViajeRepository viajeRepository) {
        this.conductorRepository = conductorRepository;
        this.viajeInDTOToViajeMapper = viajeInDTOToViajeMapper;
        this.viajeRepository = viajeRepository;
    }

    public List<ConductorDto> getConductores() {
        return conductorRepository.findAll().stream().map(ConductorDto::new).collect(Collectors.toList());
    }

    public ConductorDto getConductorById(Long id){
        Optional<Conductor> conductor = conductorRepository.findById(id);
        if(conductor.isEmpty()){
            throw new ViajesCompartidosExceptions("No existe el conductor con el id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ConductorDto(conductor.get());
    }


    public ResponseEntity<Object> crearNuevoViaje(ViajeInDTO viajeInDTO, Long id){
        //Primero obtener el conductor que publica el viaje, al menos el id
        //Asignar ese viaje a la lista de viajes del conductor
        Viaje viaje = viajeInDTOToViajeMapper.map(viajeInDTO);
        Optional<Conductor> conductorOptional = conductorRepository.findById(id);
        if(conductorOptional.isPresent()){
            Conductor conductor = conductorOptional.get();
            conductor.addViaje(viaje);
            viajeRepository.save(viaje);
            conductorRepository.save(conductor);
            return new ResponseEntity<>("Viaje creado correctamente ",HttpStatus.OK);
        } else {
            throw new ViajesCompartidosExceptions("No se puede asignar el viaje porque no existe el conductor con id: " +id, HttpStatus.NOT_FOUND);
        }
    }

    public void editarViaje(){

    }

    public void eliminarViaje(){

    }

}