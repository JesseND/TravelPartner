package edu.mum.cs544.controller;


import edu.mum.cs544.bean.Airline;
import edu.mum.cs544.bean.Airplane;
import edu.mum.cs544.bean.Airport;
import edu.mum.cs544.bean.Flight;
import edu.mum.cs544.service.AirlineService;
import edu.mum.cs544.service.AirplaneService;
import edu.mum.cs544.service.AirportService;
import edu.mum.cs544.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping()
    public String allAirports(Model model){
        List<Flight> flights = flightService.getAll();
        List<Airport> airports = airportService.getAll();
        List<Airline> airlines = airlineService.getAll();
        List<Airplane> airplanes = airplaneService.getAll();

        model.addAttribute("flights", flights);
        model.addAttribute("airports", airports);
        model.addAttribute("airlines", airlines);
        model.addAttribute("airplanes", airplanes);

        // System.out.println("Dep: "+flights.get(0).getDepartureDate());
        // return "index";
        return "flight/flightList";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model){
        Flight flight = flightService.getById(id);
        model.addAttribute("flight", flight);
        return "flight/flightDetail";
    }

    @PostMapping()
    public String add(Flight flight){
        flightService.add(flight);
        return "redirect:/flights";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id){
        flightService.delete(id);
        return "redirect:/flights";
    }
}
