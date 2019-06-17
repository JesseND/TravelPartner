package edu.mum.cs544.service;

import edu.mum.cs544.bean.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    private RestTemplate restTemplate;


    private final String airplaneUrl = "http://localhost:8077/api/airplane";
    private final String singleAirplaneUrl = "http://localhost:8077/api/airplane/{id}";

    // all airlines
    public List<Airplane> getAll(){
        ResponseEntity<List<Airplane>> responseEntity =
                restTemplate.exchange(airplaneUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Airplane>>() {});

        return responseEntity.getBody();
    }

    //add new airline
    public void add(Airplane airline) {
        System.out.println("Add.."+airline.toString());
        URI uri = restTemplate.postForLocation(airplaneUrl, airline);

    }

    // get one airline
    public Airplane getOne(Long id){
        return restTemplate.getForObject(singleAirplaneUrl, Airplane.class, id);
    }

    // delete airline
    public void delete(Long id) {
        restTemplate.delete(singleAirplaneUrl, id);
    }

}
