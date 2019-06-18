package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Airport;
import edu.mum.cs544.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping()
    public String allAirports(Model model){
        List<Airport> airports = airportService.getAll();
        model.addAttribute("airports", airports);
        return "airport/airportList";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model){
        Airport airport = airportService.getById(id);
        model.addAttribute("airport", airport);
        return "airport/airportDetail";
    }

    @PostMapping()
    public String add(Airport airport){
        airportService.add(airport);
        return "redirect:/airports";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id){
        airportService.delete(id);
        return "redirect:/airports";
    }
}
