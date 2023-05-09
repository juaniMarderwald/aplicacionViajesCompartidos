package com.viajesCompartidos.viajesCompartidos.controllers;

import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioDto;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioInDTO;
import com.viajesCompartidos.viajesCompartidos.repositories.UsuarioRepository;
import com.viajesCompartidos.viajesCompartidos.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController( UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> crearUsuario(@RequestBody UsuarioInDTO usuarioInDTO){
        return usuarioService.crearUsuario(usuarioInDTO);
    }
    @GetMapping("/{id}")
    public UsuarioDto getUsuarioPorId(@PathVariable Long id){
        return new UsuarioDto(usuarioService.getUsuarioById(id));
    }

    @GetMapping
    public List<UsuarioDto> getUsuarios(){
        return usuarioService.getTodosLosUsuarios();
    }

    @PostMapping("/{idUsuario}/viajes/{idViaje}")
    public ResponseEntity<Object> sumarseAViaje(@PathVariable Long idUsuario, @PathVariable Long idViaje ){
        return usuarioService.sumarseAViaje(idUsuario, idViaje);
    }

    @DeleteMapping("/{idUsuario}/viajes/{idViaje}")
    public ResponseEntity<Object> bajarseDeViaje(@PathVariable Long idUsuario, @PathVariable Long idViaje){
        return usuarioService.bajarseDeViaje(idUsuario,idViaje);
    }

}
