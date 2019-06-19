package edu.mum.cs544.service;

import edu.mum.cs544.bean.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private RestTemplate restTemplate;

    private final String flightUrl = "http://localhost:8077/api/flights";
    private final String singleFlightUrl = "http://localhost:8077/api/flights/{id}";

    // all airlines
    public List<Flight> getAll(){
        ResponseEntity<List<Flight>> responseEntity =
                restTemplate.exchange(flightUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>() {});
        return responseEntity.getBody();
    }

    //add new airline
    public void add(Flight flight) {
        System.out.println("Add.."+flight.toString());
        // restTemplate.
        URI uri = restTemplate.postForLocation(flightUrl, flight);
    }


    public void update(Flight flight) {
        restTemplate.put(singleFlightUrl, flight, flight.getId());
    }

    // get one airline
    public Flight getById(Long id){
        return restTemplate.getForObject(singleFlightUrl, Flight.class, id);
    }

    // delete airline
    public void delete(Long id) {
        restTemplate.delete(singleFlightUrl, id);
    }

}
