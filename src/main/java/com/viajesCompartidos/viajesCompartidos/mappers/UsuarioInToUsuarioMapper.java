package com.viajesCompartidos.viajesCompartidos.mappers;


import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInToUsuarioMapper implements IMapper<UsuarioInDTO, Usuario>{
    @Autowired
    ConductorDtoToConductorMapper conductorMapper;

    @Override
    public Usuario map(UsuarioInDTO in) {
        Usuario usuario = new Usuario();
        usuario.setNombre(in.getNombre());
        usuario.setApellido(in.getApellido());
        usuario.setUsername(in.getUserName());
        usuario.setEmail(in.getEmail());
        usuario.setPassword(in.getPassword());
        usuario.setDriver(in.isDriver());

        if(in.getConductor()!=null){
            Conductor conductor = conductorMapper.map(in.getConductor());
            usuario.setConductor(conductor);
        }

        return usuario;
    }
}
