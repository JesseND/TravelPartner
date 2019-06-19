package edu.mum.cs544.service;

import edu.mum.cs544.bean.Hotel;
import edu.mum.cs544.bean.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class RoomService {

	@Autowired
	private RestTemplate restTemplate;

	private final String roomsUrl = "http://localhost:8089/hotel/api/{id}/rooms";
	private final String roomAddUrl = "http://localhost:8089/hotel/room/api/add";
	// private final String singleHotelUrl = "http://localhost:8089/hotel/api/{id}";
	private final String roomUpdateUrl = "http://localhost:8089/hotel/api/update/{id}";

	// all Rooms
	public List<Room> getRooms(Long id) {
		ResponseEntity<List<Room>> responseEntity = restTemplate.exchange(roomsUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Room>>() {
				}, id);

		return responseEntity.getBody();
	}

	// add new room
	public void saveRoom(Room room) {
		// System.out.println("Add.." + hotel.toString());
		URI uri = restTemplate.postForLocation(roomAddUrl, room);
	}

	// update room
	public void updateRoom(Room room, Long id) {
		restTemplate.put(roomUpdateUrl, room, id);
	}

//	// get one hotel
//	public Hotel getOne(Long id) {
//		return restTemplate.getForObject(singleHotelUrl, Hotel.class, id);
//	}

// delete hotel
//	public void delete(Long id) {
//		restTemplate.delete(singleHotelUrl, id);
//	}
}
