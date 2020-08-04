package com.yy.flight.system.flightreservation.repos;


import com.yy.flight.system.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

}
