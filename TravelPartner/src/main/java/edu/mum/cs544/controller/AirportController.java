package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Airport;
import edu.mum.cs544.bean.User;
import edu.mum.cs544.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping()
    public String allAirports(Model model, HttpSession session){
        List<Airport> airports = airportService.getAll();
        model.addAttribute("airports", airports);
        User user = (User) session.getAttribute("th_user");
        model.addAttribute("user", user);
        return "th_airport/airportList";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model, HttpSession session){
        Airport airport = airportService.getById(id);
        User user = (User) session.getAttribute("th_user");
        model.addAttribute("user", user);
        model.addAttribute("airport", airport);
        return "th_airport/airportDetail";
    }

    @PostMapping()
    public String add(Airport airport){
        airportService.add(airport);
        return "redirect:/airports";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id){
        System.out.println("delete/"+ id + " --> Airport");
        airportService.delete(id);
        return "redirect:/airports";
    }

    @PostMapping(value = "/{id}")
    public String update(@ModelAttribute("airport") Airport airport){
        System.out.println("updating .. "+ airport);
        airportService.add(airport);
        return "redirect:/airports";
    }

}
