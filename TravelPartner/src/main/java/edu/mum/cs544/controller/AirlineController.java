package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Airline;
import edu.mum.cs544.bean.Flight;

import edu.mum.cs544.bean.User;
import edu.mum.cs544.service.AirlineService;

import edu.mum.cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/airlines")
// @SessionAttributes("th_user")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private UserService userService;
    @GetMapping()
    public String allAirlines(Model model, HttpSession session){
        List<Airline> airlines = airlineService.getAll();

        User user = (User) session.getAttribute("th_user");
        model.addAttribute("user", user);
        model.addAttribute("airlines", airlines);
        return "th_airline/airlineList";
    }

    // public void addUserToModel(mo)

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model, HttpSession session){
        Airline airline = airlineService.getOne(id);
        User user = (User) session.getAttribute("th_user");
        model.addAttribute("user", user);
        model.addAttribute("airline", airline);
        return "th_airline/airlineDetail";
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
