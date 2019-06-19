package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Airplane;
import edu.mum.cs544.bean.User;
import edu.mum.cs544.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/airplanes")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping()
    public String getAll(Model model, HttpSession session){
        List<Airplane> airplanes = airplaneService.getAll();

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        String role = user.getRole().toString();
        System.out.println("role--> "+role);

        boolean isAdmin = true;

        model.addAttribute("isAdmin", isAdmin);

        model.addAttribute("airplanes", airplanes);
        return "airplane/airplaneList";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model, HttpSession session){
        Airplane airplane = airplaneService.getOne(id);
        model.addAttribute("airplane", airplane);

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        return "airplane/airplaneDetail";
    }

    @PostMapping()
    public String add(Airplane airplane){
        airplaneService.add(airplane);
        return "redirect:/airplanes";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id){
        airplaneService.delete(id);
        return "redirect:/airplanes";
    }
}
