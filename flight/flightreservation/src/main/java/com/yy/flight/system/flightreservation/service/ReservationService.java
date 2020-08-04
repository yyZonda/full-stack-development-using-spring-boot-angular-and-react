package com.yy.flight.system.flightreservation.service;


import com.yy.flight.system.flightreservation.dto.ReservationRequest;
import com.yy.flight.system.flightreservation.entities.Reservation;

public interface ReservationService {
    public Reservation bookFlight(ReservationRequest request);
}
