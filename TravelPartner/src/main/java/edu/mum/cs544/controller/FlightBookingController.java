package edu.mum.cs544.controller;

import edu.mum.cs544.bean.Booking;
import edu.mum.cs544.bean.Flight;
import edu.mum.cs544.bean.User;
import edu.mum.cs544.service.FlightBookingService;
import edu.mum.cs544.service.FlightService;
import edu.mum.cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/bookings")
public class FlightBookingController {

    @Autowired
    private FlightBookingService bookingService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public String allAirlines(Model model){
        List<Booking> bookings = bookingService.getAll();

        model.addAttribute("bookings", bookings);
        return "bookings/bookingList";
    }

    /** shows a single view of one booking*/
    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model){
        Booking booking = bookingService.getById(id);

        long flightId = booking.getFlight_id();
        model.addAttribute("booking", booking);
        return "redirect:/flights/"+flightId;
    }

    /** shows a list of all bookings of one user*/
    @GetMapping(value = "/user/{id}")
    public String listOfBookingByUser(@PathVariable Integer id, Model model){
        // User user = userService.getById(id);

        // Long userId = (Long) id;

        User user = userService.get(id);

        List<Booking> bookings = bookingService.getAllById(id);

        List<Flight> flights = new ArrayList<>();

        for(Booking b: bookings){
            flights.add(flightService.getById(b.getFlight_id()));
        }

        model.addAttribute("flights", flights);
        model.addAttribute("user", user);

        return "bookings/bookingDetail";
    }


    @PostMapping()
    public String add(Booking booking){
        bookingService.add(booking);
        return "redirect:/bookings";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id){
        bookingService.delete(id);
        return "redirect:/bookings";
    }
}
