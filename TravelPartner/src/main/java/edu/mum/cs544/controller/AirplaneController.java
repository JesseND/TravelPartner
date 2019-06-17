package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Airplane;
import edu.mum.cs544.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/airplanes")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping()
    public String allAirlines(Model model){
        List<Airplane> airplanes = airplaneService.getAll();

        model.addAttribute("airplanes", airplanes);
        return "airplane/airplaneList";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model){
        Airplane airplane = airplaneService.getOne(id);
        model.addAttribute("airplane", airplane);
        return "airplane/airplaneDetail";
    }

    @PostMapping()
    public String add(Airplane airplane){
        airplaneService.add(airplane);
        return "redirect:/airplanes";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id){
        airplaneService.delete(id);
        return "redirect:/airplanes";
    }
}
