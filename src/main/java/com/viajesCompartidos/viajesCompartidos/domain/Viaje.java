package com.viajesCompartidos.viajesCompartidos.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name="viajes")
@Entity
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ciudadInicio;
    private String ciudadDestino;
    private LocalDate horaSalida;
    private Integer lugaresDisponibles;
    private boolean aceptaMascotas;
    private boolean finished;

    @ManyToMany
    @JoinTable(
            name = "viajes_pasajeros",
            joinColumns = @JoinColumn(name = "viaje_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    protected List<Usuario> pasajeros = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    public void addPasajero(Usuario usuario){
        if(this.lugaresDisponibles>0){
            pasajeros.add(usuario);
            this.lugaresDisponibles--;
            usuario.addViaje(this);
        }
    }

    public void borrarPasajeroDeViaje(Usuario usuario){
        if(this.pasajeros.contains(usuario)){
            this.pasajeros.remove(usuario);
            this.lugaresDisponibles++;
            usuario.removeViaje(this);
        }
    }
}
