package edu.mum.cs544.service;

import edu.mum.cs544.bean.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class HotelService {

	@Autowired
	private RestTemplate restTemplate;

	private final String hotelsUrl = "http://localhost:8089/hotel/api/list";
	private final String hotelAddUrl = "http://localhost:8089/hotel/api/add";
	private final String singleHotelUrl = "http://localhost:8089/hotel/api/{id}";
	private final String hotelUpdateUrl = "http://localhost:8089/hotel/api/update/{id}";

	// all hotels
	public List<Hotel> getAll() {
		ResponseEntity<List<Hotel>> responseEntity = restTemplate.exchange(hotelsUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Hotel>>() {
				});

		return responseEntity.getBody();
	}

	// add new hotel
	public void save(Hotel hotel) {
		// System.out.println("Add.." + hotel.toString());
		URI uri = restTemplate.postForLocation(hotelAddUrl, hotel);
	}
	
	//update hotel
	public void update(Hotel hotel, Long id) {
		restTemplate.put(hotelUpdateUrl, hotel, id);
	}

	// get one hotel
	public Hotel getOne(Long id) {
		return restTemplate.getForObject(singleHotelUrl, Hotel.class, id);
	}

	// delete hotel
	public void delete(Long id) {
		restTemplate.delete(singleHotelUrl, id);
	}
}
