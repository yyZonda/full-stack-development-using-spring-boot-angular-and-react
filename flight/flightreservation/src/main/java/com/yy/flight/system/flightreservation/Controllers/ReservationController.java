package com.yy.flight.system.flightreservation.Controllers;


import com.yy.flight.system.flightreservation.dto.ReservationRequest;
import com.yy.flight.system.flightreservation.entities.Flight;
import com.yy.flight.system.flightreservation.entities.Reservation;
import com.yy.flight.system.flightreservation.repos.FlightRepository;
import com.yy.flight.system.flightreservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){
        LOGGER.info("Inside showCompleteReservation()");
        Flight flight= flightRepository.findById(flightId);
        modelMap.addAttribute("flight",flight);
        LOGGER.info("Flight is :"+flight);
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap){
        LOGGER.info("Inside completeReservation()"+request);
        Reservation reservation=reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Reservation created successfully and the id is"+reservation.getId());
        return "reservationConfirmation";
    }
}
