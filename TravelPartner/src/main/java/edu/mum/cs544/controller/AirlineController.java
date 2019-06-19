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
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping()
    public String allAirlines(Model model){
        List<Airline> airlines = airlineService.getAll();

        model.addAttribute("airlines", airlines);
        return "airline/airlineList";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model){
        Airline airline = airlineService.getOne(id);
        model.addAttribute("airline", airline);
        return "airline/airlineDetail";
    }

    @PostMapping()
    public String add(Airline airline){
        airlineService.add(airline);
        return "redirect:/airlines";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id){
        airlineService.delete(id);
        return "redirect:/airlines";
    }
}
