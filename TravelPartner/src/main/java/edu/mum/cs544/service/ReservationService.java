package edu.mum.cs544.service;

import java.net.URI;

import edu.mum.cs544.bean.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import edu.mum.cs544.bean.Reservation;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private RestTemplate restTemplate;

    private final String addReservationUrl = "http://localhost:8089/hotel/api/add/reservation";
    private final String reservationUrl = "http://localhost:8089/hotel/api/myReservations";
    
    //add new reservation
 	public void saveReservation(Reservation reservation) {
 		URI uri = restTemplate.postForLocation(addReservationUrl, reservation);
 	}

 	//getAll reservation
    public List<Reservation> getAllReservations(long id){
        ResponseEntity<List<Reservation>> responseEntity =
                restTemplate.exchange(reservationUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Reservation>>() {});
        return responseEntity.getBody()
                .stream().filter(reservation -> reservation.getUserId() == id)
                .collect(Collectors.toList());
    }
    
}
