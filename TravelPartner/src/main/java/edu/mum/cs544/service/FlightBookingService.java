package edu.mum.cs544.service;

import edu.mum.cs544.bean.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightBookingService {

    @Autowired
    private RestTemplate restTemplate;

    private final String bookingUrl = "http://localhost:8077/api/booking/";
    private final String singleBookingUrl = "http://localhost:8077/api/booking/{id}";
   //  /bookings/th_user/{id}

    // all airlines
    public List<Booking> getAll(){
        ResponseEntity<List<Booking>> responseEntity =
                restTemplate.exchange(bookingUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Booking>>() {});
        return responseEntity.getBody();
    }

    public List<Booking> getAllById(int id){
        ResponseEntity<List<Booking>> responseEntity =
                restTemplate.exchange(bookingUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Booking>>() {});
        return responseEntity.getBody()
                .stream().filter(booking -> booking.getUser_id() == id)
                .collect(Collectors.toList());
    }

    //add new airline
    public void add(Booking booking) {
        System.out.println("Add.."+booking.toString());
        URI uri = restTemplate.postForLocation(bookingUrl, booking);

    }

    // get one airline
    public Booking getById(Long id){
        return restTemplate.getForObject(singleBookingUrl, Booking.class, id);
    }



    // delete airline
    public void delete(Long id) {
        restTemplate.delete(singleBookingUrl, id);
    }
}
