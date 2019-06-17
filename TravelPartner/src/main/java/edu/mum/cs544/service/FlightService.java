package edu.mum.cs544.service;

import edu.mum.cs544.bean.Airline;
import edu.mum.cs544.bean.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private RestTemplate restTemplate;

    private final String flightUrl = "http://localhost:8088/api/flights";
    private final String airlineUrl = "http://localhost:8088/api/airline";

    public List<Flight> getAll(){
        ResponseEntity<List<Flight>> responseEntity =
                restTemplate.exchange(flightUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>() {});

        return responseEntity.getBody();
    }

    // airlines
    public List<Airline> getAirlines(){
        ResponseEntity<List<Airline>> responseEntity =
                restTemplate.exchange(airlineUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airline>>() {});

        return responseEntity.getBody();
    }
}
