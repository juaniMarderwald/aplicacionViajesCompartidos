package com.viajesCompartidos.viajesCompartidos.repositories;

import com.viajesCompartidos.viajesCompartidos.domain.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends JpaRepository<Viaje,Long> {
}
