package com.yy.flight.system.flightreservation.Controllers;


import com.yy.flight.system.flightreservation.dto.ReservationUpdateRequest;
import com.yy.flight.system.flightreservation.entities.Reservation;
import com.yy.flight.system.flightreservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRESTController {

    @Autowired
    ReservationRepository reservationRepository;

    Logger LOGGER = LoggerFactory.getLogger(ReservationRESTController.class);

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        LOGGER.info("inside findReservation for id:"+id);
        Reservation reservation=reservationRepository.findById(id);
        return reservation;
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        LOGGER.info("inside findReservation for request:"+ request);
        Reservation reservation=reservationRepository.findById(request.getId());
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        LOGGER.info("Saving reservation");
        return reservationRepository.save(reservation);
    }

}
