package com.viajesCompartidos.viajesCompartidos;

import com.viajesCompartidos.viajesCompartidos.domain.Usuario;
import com.viajesCompartidos.viajesCompartidos.dto.ConductorInDTO;
import com.viajesCompartidos.viajesCompartidos.dto.UsuarioInDTO;
import com.viajesCompartidos.viajesCompartidos.dto.ViajeInDTO;
import com.viajesCompartidos.viajesCompartidos.repositories.UsuarioRepository;
import com.viajesCompartidos.viajesCompartidos.services.ConductorService;
import com.viajesCompartidos.viajesCompartidos.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ViajesCompartidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViajesCompartidosApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioService usuarioService,
									  ConductorService conductorService){
		return (args) -> {
			UsuarioInDTO usuario1 = new UsuarioInDTO("juancito@juanchito", "Juan", "Juancito",
					"Juancito1234", "123456", true,
					new ConductorInDTO(5.0, "abc123"));
			usuarioService.crearUsuario(usuario1);

			UsuarioInDTO usuario2 = new UsuarioInDTO("juan@farinati", "Juan", "Farinati",
					"JuancitoFari", "123456", false,null);

			usuarioService.crearUsuario(usuario2);

			UsuarioInDTO usuario3 = new UsuarioInDTO("nico@cadenas", "Nicolai", "Cadenoide",
					"NicoCadenas", "123456", true,
					new ConductorInDTO(5.0, "rti908"));
			usuarioService.crearUsuario(usuario3);

			ViajeInDTO viaje1 = new ViajeInDTO("Tandil","Capital federal", LocalDate.now(),4,true);
			conductorService.crearNuevoViaje(viaje1,1L);

			ViajeInDTO viaje2 = new ViajeInDTO("La Rioja","San Luis", LocalDate.now().plusMonths(1),4,true);
			conductorService.crearNuevoViaje(viaje2,2L);

		};
	}
}
