package com.viajesCompartidos.viajesCompartidos.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "user_name")
    private String username;

    @Column(name="password")
    private String password;

    @Column( name="es_conductor")
    private boolean driver;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Conductor conductor;

    @ManyToMany(mappedBy = "pasajeros")
    private List<Viaje> viajes = new ArrayList<>();

    public void addViaje(Viaje viaje){
        this.viajes.add(viaje);
    }

    public void removeViaje(Viaje viaje) {
        this.viajes.remove(viaje);
    }
}
