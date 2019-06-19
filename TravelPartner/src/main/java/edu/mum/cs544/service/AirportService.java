package edu.mum.cs544.service;


import edu.mum.cs544.bean.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class AirportService {

    @Autowired
    private RestTemplate restTemplate;


    private final String airportUrl = "http://localhost:8077/api/airport";
    private final String singleAirportUrl = "http://localhost:8077/api/airport/{id}";

    // all airlines
    public List<Airport> getAll(){
        ResponseEntity<List<Airport>> responseEntity =
                restTemplate.exchange(airportUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>() {});

        return responseEntity.getBody();
    }

    //add new airline -- or update
    public void add(Airport airport) {
        System.out.println("Add.."+airport.toString());
        URI uri = restTemplate.postForLocation(airportUrl, airport);
    }

    // get one airline
    public Airport getById(Long id){
        return restTemplate.getForObject(singleAirportUrl, Airport.class, id);
    }

    // delete airline
    public void delete(Long id) {
        restTemplate.delete(singleAirportUrl, id);
    }

}
