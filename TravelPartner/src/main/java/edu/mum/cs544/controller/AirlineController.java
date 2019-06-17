package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Airline;
import edu.mum.cs544.bean.Flight;

import edu.mum.cs544.service.AirlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping(value = "/airlines")
    public String allAirlines(Model model){
        List<Airline> airlines = airlineService.getAirlines();

        model.addAttribute("airlines", airlines);
        return "airlineList";
    }

    @PostMapping(value = "/airlines")
    public String add(Airline airline){
        airlineService.add(airline);
        return "redirect:/airlines";
    }


    @GetMapping(value = "/flights")
    public String allFlights(Model model){
        List<Flight> flightList = airlineService.getAll();
        model.addAttribute("flights", flightList);

        return "flight/flightList";
    }


}
