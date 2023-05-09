package com.viajesCompartidos.viajesCompartidos.services;

import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioDto;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioInDTO;
import com.viajesCompartidos.viajesCompartidos.exceptions.ViajesCompartidosExceptions;
import com.viajesCompartidos.viajesCompartidos.mappers.UsuarioInToUsuarioMapper;
import com.viajesCompartidos.viajesCompartidos.repositories.ConductorRepository;
import com.viajesCompartidos.viajesCompartidos.repositories.UsuarioRepository;
import com.viajesCompartidos.viajesCompartidos.repositories.ViajeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioInToUsuarioMapper mapper;
    private final ConductorRepository conductorRepository;

    private final ViajeRepository viajeRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioInToUsuarioMapper mapper, ConductorRepository conductorRepository, ViajeRepository viajeRepository) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
        this.conductorRepository = conductorRepository;
        this.viajeRepository = viajeRepository;
    }

    public ResponseEntity<Object> crearUsuario(UsuarioInDTO usuarioInDTO){
        Usuario usuario = mapper.map(usuarioInDTO);

        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()){
            throw new ViajesCompartidosExceptions("Usuario existente, no se puede crear", HttpStatus.FORBIDDEN);
        }

        Conductor conductor = usuario.getConductor();
        usuarioRepository.save(usuario);

        if (usuario.getConductor()!=null){
            conductor.setUsuario(usuario);
            conductorRepository.save(conductor);
        }
        return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.OK);
    }

    public Usuario getUsuarioById(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new ViajesCompartidosExceptions("No existe el usuario con el id: " + id, HttpStatus.FORBIDDEN);
        }
        return usuario.get();
    }

    public List<UsuarioDto> getTodosLosUsuarios(){
        return usuarioRepository.findAll().stream().map(UsuarioDto::new).collect(Collectors.toList());
    }

    public ResponseEntity<Object> sumarseAViaje(Long idUsuario,Long idViaje){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        Optional<Viaje> viajeOptional = viajeRepository.findById(idViaje);

        if (usuarioOptional.isEmpty()){
            throw new ViajesCompartidosExceptions("El usuario con id: "+ idUsuario+ " No existe!",HttpStatus.NOT_FOUND);
        }
        if (viajeOptional.isEmpty()){
            throw new ViajesCompartidosExceptions("El viaje con id: "+ idViaje + " No existe!",HttpStatus.NOT_FOUND);
        }

        Viaje viaje = viajeOptional.get();
        Usuario usuario = usuarioOptional.get();

        if(viaje.getPasajeros().contains(usuario)){
            throw new ViajesCompartidosExceptions("Usuario ya se encuentra registrado para participar del viaje.",HttpStatus.NOT_FOUND);
        }

        if(viaje.getLugaresDisponibles()==0){
            throw new ViajesCompartidosExceptions("Ya no quedan lugares disponibles para este viaje.",HttpStatus.NOT_FOUND);
        }else {
            viaje.addPasajero(usuario);
            viajeRepository.save(viaje);
            return new ResponseEntity<>("Pasajero agreado a viaje con exito", HttpStatus.OK);
        }


    }
}
