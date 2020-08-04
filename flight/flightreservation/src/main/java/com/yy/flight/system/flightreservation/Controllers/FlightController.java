package com.yy.flight.system.flightreservation.Controllers;

import com.yy.flight.system.flightreservation.entities.Flight;
import com.yy.flight.system.flightreservation.repos.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

//    @RequestMapping(value = "/findFlights")
////    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate")
////    @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap modelMap){
////        List<Flight> flights=flightRepository.findFlights(from,to,departureDate);
////        System.out.println("from:"+from+"to:"+to+"time:"+departureDate);
////        modelMap.addAttribute("flights",flights);
////        return "displayFlights";
////    }

    @RequestMapping(value = "/findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate")
    @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap modelMap){
        LOGGER.info("Inside findFlights()"+from+"To"+to+"Departure Date"+departureDate);
        List<Flight> flights=flightRepository.findFlights(from,to);
        System.out.println("from:"+from+"to:"+to+"time:"+departureDate);
        modelMap.addAttribute("flights",flights);
        return "displayFlights";
    }

}
