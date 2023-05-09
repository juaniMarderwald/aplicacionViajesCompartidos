package com.viajesCompartidos.viajesCompartidos.repositories;

import com.viajesCompartidos.viajesCompartidos.domain.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor,Long> {
}
