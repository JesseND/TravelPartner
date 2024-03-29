package edu.mum.cs544.controller;


import edu.mum.cs544.bean.*;
import edu.mum.cs544.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    @Autowired
    private FlightBookingService bookingService;

    private DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);

    private DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

    @GetMapping()
    public String allAirports(Model model, HttpSession session) {
        List<Flight> flights = flightService.getAll();
        List<Airport> airports = airportService.getAll();
        List<Airline> airlines = airlineService.getAll();
        List<Airplane> airplanes = airplaneService.getAll();

        model.addAttribute("flights", flights);
        model.addAttribute("airports", airports);
        model.addAttribute("airlines", airlines);
        model.addAttribute("airplanes", airplanes);

        User user = (User) session.getAttribute("th_user");
        model.addAttribute("user", user);

        return "th_flight/flightList";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable Long id, Model model, HttpSession session) {
        Flight flight = flightService.getById(id);

        Date arr = flight.getArrivalDate();
        Date dep = flight.getDepartureDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat time = new SimpleDateFormat("HH:mm");

        List<Airport> airports = airportService.getAll();
        List<Airline> airlines = airlineService.getAll();
        List<Airplane> airplanes = airplaneService.getAll();

        model.addAttribute("airports", airports);
        model.addAttribute("airlines", airlines);
        model.addAttribute("airplanes", airplanes);

        // model.addAttribute("flight", flight);

        // System.out.println("date arr: "+ format.format(arr));

        User user = (User) session.getAttribute("th_user");
        model.addAttribute("user", user);

        model.addAttribute("arrDate", format.format(arr));
        model.addAttribute("depDate", format.format(dep));

        model.addAttribute("arrTime", time.format(flight.getArrivalTime()));
        model.addAttribute("depTime", time.format(flight.getDepartureTime()));

        model.addAttribute("flight", flight);
        return "th_flight/flightDetail";
    }

    private Flight getFlight(String flightnr, String departureDate, String departureTime,
                             String arrivalDate, String arrivalTime, String airline,
                             String airplane, String origin, String destination) throws ParseException {
        SimpleDateFormat spdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sptf = new SimpleDateFormat("HH:mm");

        Date depDate = spdf.parse(departureDate);
        Date depTime = sptf.parse(departureTime);

        Date arrDate = spdf.parse(arrivalDate);
        Date arrTime = sptf.parse(arrivalTime);

        Airline airline1 = airlineService.getOne(Long.parseLong(airline));
        // airlineService.add(airline1);

        // System.out.println("airplane "+ airplane);
        Airplane airplane1 = airplaneService.getOne(Long.parseLong(airplane));
        // airplaneService.add(airplane1);
        Airport originAirport = airportService.getById(Long.parseLong(origin));
        // airportService.add(originAirport);
        Airport destAirport = airportService.getById(Long.parseLong(destination));
        //airportService.add(destAirport);

        Flight flight = new Flight();

        // set things
        flight.setAirline(airline1);
        flight.setAirplane(airplane1);
        flight.setFlightnr(flightnr);
        flight.setDestination(destAirport);
        flight.setOrigin(originAirport);
        flight.setDepartureDate(depDate);
        flight.setDepartureTime(depTime);
        flight.setArrivalDate(arrDate);
        flight.setArrivalTime(arrTime);

        return flight;
    }

    @PostMapping(value = "/{id}")
    public String update(String id, String flightnr, String departureDate, String departureTime,
                         String arrivalDate, String arrivalTime, String airline,
                         String airplane, String origin, String destination) throws ParseException {

        Flight flight = getFlight(flightnr, departureDate,
                departureTime, arrivalDate, arrivalTime, airline, airplane, origin, destination);

        System.out.println("id= " + id);
        flight.setId(Long.parseLong(id));
        flightService.update(flight);
        // add id to html form as hidden
        return "redirect:/flights";
    }

    /*book a flight with of that id*/
    @GetMapping(value = "/booking/{flightId}")
    public String book(@PathVariable long flightId, HttpSession session, Model model) {

        User user = (User) session.getAttribute("th_user");

        System.out.println("th_user in session: " + user.toString());
        
        Booking booking = new Booking();
        booking.setActive(true);
        booking.setFlight_id(flightId);
        booking.setUser_id(user.getId());

        bookingService.add(booking);

        return "redirect:/bookings/user/" + user.getId();
    }


    @PostMapping()
    public String add(String flightnr, String departureDate, String departureTime,
                      String arrivalDate, String arrivalTime, String airline,
                      String airplane, String origin, String destination) throws ParseException {

        Flight flight = getFlight(flightnr, departureDate,
                departureTime, arrivalDate, arrivalTime, airline, airplane, origin, destination);

        //System.out.println("new : "+flight);

        System.out.println("flight = " + flight);
        // if(id == null || id == 0){
        flightService.add(flight);
        //}else{
        // flightService.update(flight);
        // }

        return "redirect:/flights";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        System.out.println("/delete/" + id + " --> Flight");
        flightService.delete(id);
        return "redirect:/flights";
    }

}
