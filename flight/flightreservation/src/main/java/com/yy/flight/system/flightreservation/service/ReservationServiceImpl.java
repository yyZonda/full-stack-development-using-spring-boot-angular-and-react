package com.yy.flight.system.flightreservation.service;


import com.yy.flight.system.flightreservation.dto.ReservationRequest;
import com.yy.flight.system.flightreservation.entities.Flight;
import com.yy.flight.system.flightreservation.entities.Passenger;
import com.yy.flight.system.flightreservation.entities.Reservation;
import com.yy.flight.system.flightreservation.repos.FlightRepository;
import com.yy.flight.system.flightreservation.repos.PassengerRepository;
import com.yy.flight.system.flightreservation.repos.ReservationRepository;
//import com.yy.flight.system.flightreservation.util.EmailUtil;
import com.yy.flight.system.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Value("${com.yy.fight.flightreservation.itineraray.dirpath}")
    public  String ITINERARY;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

//    @Autowired
//    EmailUtil emailUtil;

    Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {

        LOGGER.info("Inside bookFlight()");
        //Make Payment

        Long flightId=request.getFlightId();
        Flight flight=flightRepository.findById(flightId);

        Passenger passenger=new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger=passengerRepository.save(passenger);

        Reservation reservation=new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        LOGGER.info("saving the reservation");
        Reservation savedReservation=reservationRepository.save(reservation);

        String Url=ITINERARY+savedReservation.getId()+".pdf";
        LOGGER.info("Generate PDF");

        pdfGenerator.genarateItinerary(savedReservation,Url);
//        emailUtil.sendItinerary(passenger.getEmail(),Url);

        return savedReservation;
    }
}
