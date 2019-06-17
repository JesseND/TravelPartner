package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Airline;
import edu.mum.cs544.bean.Flight;

import edu.mum.cs544.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/airlines")
    public String allAirlines(Model model){
        List<Airline> airlines = flightService.getAirlines();

        model.addAttribute("airlines", airlines);
        return "airlineList";
    }


    @GetMapping(value = "/flights")
    public String allFlights(Model model){
        List<Flight> flightList = flightService.getAll();
        model.addAttribute("flights", flightList);

        return "flight/flightList";
    }
}
