package edu.mum.cs544.service;

import edu.mum.cs544.bean.Airline;
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
public class AirlineService {

    @Autowired
    private RestTemplate restTemplate;

    private final String airlineUrl = "http://localhost:8077/api/airline";
    private final String singleAirlineUrl = "http://localhost:8077/api/airline/{id}";


    // all airlines
    public List<Airline> getAll(){
        ResponseEntity<List<Airline>> responseEntity =
                restTemplate.exchange(airlineUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airline>>() {});

        return responseEntity.getBody();
    }

    //add new airline
    public void add(Airline airline) {
        System.out.println("Add.."+airline.toString());
        URI uri = restTemplate.postForLocation(airlineUrl, airline);
    }

    // get one airline
    public Airline getOne(Long id){
        return restTemplate.getForObject(singleAirlineUrl, Airline.class, id);
    }

    // delete airline
    public void delete(Long id) {
        restTemplate.delete(singleAirlineUrl, id);
    }
}
