package com.yy.flight.flightcheckin.integration;


import com.yy.flight.flightcheckin.integration.dto.Reservation;
import com.yy.flight.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    @Value("${com.yy.flight.flightreservation.reservation}")
    public  String RESERVATIONS ;

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATIONS+id,Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate= new RestTemplate();
        Reservation reservation = restTemplate.postForObject(RESERVATIONS,request,Reservation.class);

        return reservation;
    }
}
