package com.viajesCompartidos.viajesCompartidos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="conductores")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    @Column(name = "reputacion")
    private double reputacion;

    private String licenciaDeConducir;

    @OneToOne
    @JoinColumn(name="id_usuario")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Viaje> viajes = new HashSet<>();

    /*@OneToMany
    private Set<Calificacion> calificaciones = new HashSet<>();*/

    public void addViaje(Viaje viaje){
        this.viajes.add(viaje);
        viaje.setConductor(this);
    }

    @JsonIgnore
    public Usuario getUsuario(){
        return this.usuario;
    }

}
