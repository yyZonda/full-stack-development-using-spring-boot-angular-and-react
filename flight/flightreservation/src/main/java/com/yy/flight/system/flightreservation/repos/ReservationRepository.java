package com.yy.flight.system.flightreservation.repos;

import com.yy.flight.system.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    public Reservation findById(Long id);
}
