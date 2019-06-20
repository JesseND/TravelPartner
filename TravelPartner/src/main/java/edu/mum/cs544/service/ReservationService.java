package edu.mum.cs544.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import edu.mum.cs544.bean.Reservation;

@Service
public class ReservationService {

    @Autowired
    private RestTemplate restTemplate;

    private final String addReservationUrl = "http://localhost:8089/hotel/api/add/reservation";
    
 // add new reservation
 	public void saveReservation(Reservation reservation) {
 		URI uri = restTemplate.postForLocation(addReservationUrl, reservation);
 	}
    
}
