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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String allAirlines(Model model, HttpSession session){
        List<Booking> bookings = bookingService.getAll();

        model.addAttribute("bookings", bookings);

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        return "th_bookings/bookingList";
    }

    /** search flights by origin and destination*/
    @GetMapping(value = "/search")
    public String search(){
        System.out.println("we are searching");

        return "th_bookings/search";
    }

    @PostMapping(value = "/search")
    public String searchResult(HttpSession session,  @RequestParam String origin, @RequestParam String destination, Model model){

        List<Flight> flightsByQuery = flightService.flightsByQuery(origin, destination);

        User user = (User) session.getAttribute("user");

        boolean isEmpty = true;
        boolean isLoggedIn = false;

        if(session.getAttribute("user") != null)
            isLoggedIn = true;

        if(flightsByQuery.size() > 0)
            isEmpty = false;

        model.addAttribute("isEmpty", isEmpty);

        System.out.println(origin +" --> " + destination);


        model.addAttribute("user", user);

        model.addAttribute("isLoggedIn", isLoggedIn);
        model.addAttribute("origin", origin);
        model.addAttribute("destination", destination);
        model.addAttribute("flights", flightsByQuery);

        return "th_flight/flightQuery";
    }

    /** shows a single view of one booking*/
    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model, HttpSession session){
        Booking booking = bookingService.getById(id);

        long flightId = booking.getFlight_id();
        model.addAttribute("booking", booking);
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "redirect:/flights/"+flightId;
    }

    /** shows a list of all bookings of one user*/
    @GetMapping(value = "/user/{id}")
    public String listOfBookingByUser(@PathVariable Integer id, Model model){
        User user = userService.get(id);

        boolean noBooking = false;

        List<Booking> bookings = bookingService.getAllById(id);

        if(bookings.size() > 0)
            noBooking = true;

        List<Flight> flights = new ArrayList<>();

        for(Booking b: bookings){
            flights.add(flightService.getById(b.getFlight_id()));
        }

        model.addAttribute("noBooking", noBooking);
        model.addAttribute("flights", flights);
        model.addAttribute("user", user);

        System.out.println("/bookings/user/"+user.getId());

        return "th_bookings/bookingDetail";
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
