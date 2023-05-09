package com.viajesCompartidos.viajesCompartidos.dto;

import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class UsuarioDto {

    private Long id;
    private String correoElectronico;
    private String nombre;
    private String apellido;
    private String userName;
    private boolean isDriver;
    private ConductorDto conductor;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.correoElectronico = usuario.getEmail();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.userName = usuario.getUsername();
        this.isDriver = usuario.isDriver();
        Conductor conductor = usuario.getConductor();
        if (conductor!= null){
            this.conductor = new ConductorDto(conductor);
        }else{
            this.conductor=null;
        }

    }

}
