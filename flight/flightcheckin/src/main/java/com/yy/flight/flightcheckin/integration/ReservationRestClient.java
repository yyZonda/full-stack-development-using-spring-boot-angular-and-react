package com.yy.flight.flightcheckin.integration;


import com.yy.flight.flightcheckin.integration.dto.Reservation;
import com.yy.flight.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest request);
}
