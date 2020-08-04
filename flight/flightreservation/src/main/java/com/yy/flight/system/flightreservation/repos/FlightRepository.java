package com.yy.flight.system.flightreservation.repos;


import com.yy.flight.system.flightreservation.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {

//    @Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
//    List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity")String to, @Param("dateOfDeparture")Date departureDate);

    @Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity ")
    List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to);

    Flight findById(Long id);

}
