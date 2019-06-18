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

    private DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
            Locale.US);

    private  DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
            Locale.US);

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

//    @PostMapping()
//    public String add(Flight flight){
//        flightService.add(flight);
//        return "redirect:/flights";
//    }

    @PostMapping()
    public String add(String flightnr, String departureDate, String departureTime,
                      String arrivalDate, String arrivalTime, String airline,
                      String airplane, String origin, String destination) throws ParseException {

//        System.out.println(flightnr +"\n"+
//                departureDate +"\n"+
//                departureTime +"\n"+
//                arrivalDate +"\n"+
//                arrivalTime +"\n"+
//                airline +"\n"+
//                airplane +"\n"+
//                origin +"\n"+
//                destination);
//        SimpleDateFormat  spdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat  sptf = new SimpleDateFormat("HH:mm");
//
//        Date depDate = spdf.parse(departureDate);
//        Date depTime = sptf.parse(departureTime);
//
//        Date arrDate = spdf.parse(arrivalDate);
//        Date arrTime = sptf.parse(arrivalTime);
//
//        Airline airline1 = airlineService.getOne(Long.parseLong(airline));
//        airlineService.add(airline1);
//        Airplane airplane1 = airplaneService.getOne(Long.parseLong(airplane));
//        airplaneService.add(airplane1);
//        Airport originAirport = airportService.getById(Long.parseLong(origin));
//        airportService.add(originAirport);
//        Airport destAirport = airportService.getById(Long.parseLong(destination));
//        airportService.add(destAirport);
//
//        Flight flight = new Flight();
//
//        // set things
//        flight.setAirline(airline1);
//        flight.setAirplane(airplane1);
//        flight.setFlightnr(flightnr);
//        flight.setDestination(destAirport);
//        flight.setOrigin(originAirport);
//        flight.setDepartureDate(depDate);
//        flight.setDepartureTime(depTime);
//        flight.setArrivalDate(arrDate);
//        flight.setArrivalTime(arrTime);
//
//        System.out.println("new flight: "+flight);
//        // save other entities before
//

        // flightService.add(flight);

        String updateQuery =
                "INSERT INTO `ticketmicro`.`flight`" +
                        "(`arrival_date`, `arrival_time`, " +
                        "`departure_date`, `departure_time`, `flightnr`," +
                        " `airline_id`, `airplane_id`, `destination_id`, `origin_id`) " +
                        "VALUES ('"+ arrivalDate+ "', '"+
                        arrivalTime+ "', '"+
                        departureDate+"', '"+
                        departureTime+"', '"+
                        flightnr+"', "+
                        Long.parseLong(airline)+" , "+
                        Long.parseLong(airplane)+" , "+
                        Long.parseLong(destination)+", "+
                        Long.parseLong(origin)+ ")";

        flightService.addByQuery(updateQuery);
        return "redirect:/flights";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id){
        flightService.delete(id);
        return "redirect:/flights";
    }
}
