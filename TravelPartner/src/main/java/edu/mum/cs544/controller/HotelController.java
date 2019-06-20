package edu.mum.cs544.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.bean.*;
import edu.mum.cs544.service.HotelService;
import edu.mum.cs544.service.ReservationService;
import edu.mum.cs544.service.RoomService;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hService;

	@Autowired
	private RoomService rService;

	@Autowired
	private ReservationService resService;

	@GetMapping("/list")
	private String getHotelList(Model model) {
		model.addAttribute("hotels", hService.getAll());
		System.out.println("GET: /hotel/list");
		return "hotelsList";
	}

	@GetMapping("/{id}")
	private String getHotel(@PathVariable long id, Model model) {
		model.addAttribute("hotel", hService.getOne(id));
		System.out.println("POST: /hotel/list");
		return "hotelDetails";
	}

	@GetMapping("/add")
	private String addHotel(@ModelAttribute("hotel") Hotel hotel) {
		return "addHotelForm";
	}

	@PostMapping("/add")
	private String addHotel(@Valid @ModelAttribute("hotel") Hotel hotel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addHotelForm";
		}
		hService.save(hotel);
		return "redirect:/hotel/list";
	}

	@GetMapping("/update/{id}")
	public String update(@ModelAttribute("hotel") Hotel hotel, @PathVariable long id, Model model) {
		model.addAttribute("ht", hService.getOne(id));
		return "updateHotelForm";
	}

	@PostMapping("/update/{id}")
	private String updateHotel(@Valid @ModelAttribute("hotel") Hotel hotel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/hotel/update/{id}";
		}
		hService.update(hotel, hotel.getId());
		return "redirect:/hotel/list";
	}

	@GetMapping("/delete/{id}")
	private String delete(@PathVariable long id, Model model) {
		model.addAttribute("hotel", hService.getOne(id));
		return "deleteHotelForm";
	}

	@GetMapping("/{id}/rooms")
	private String getRooms(@PathVariable long id, Model model) {
		model.addAttribute("rooms", rService.getRooms(id));
		return "hotelRooms";
	}

	@GetMapping("/reservation/{hotelId}/{roomNumber}")
	private String reservation(@PathVariable long hotelId, @PathVariable long roomNumber,
			@ModelAttribute("reservation") Reservation reservation, Model model) {
		model.addAttribute("hId", hotelId);
		model.addAttribute("hname", hService.getOne(hotelId).getName());
		model.addAttribute("rn", roomNumber);
		return "reservationRoomForm";
	}

	@PostMapping("/reservation/{hotelId}/{roomNumber}")
	private String addReservation(@PathVariable long hotelId, @PathVariable long roomNumber, @Valid @ModelAttribute("reservation") Reservation reservation, BindingResult result,
			Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		reservation.setUserId(user.getId());
		System.out.println("------------> "+user.getId()+"<-------------------");
		RoomIdentity rd = new RoomIdentity(hotelId, roomNumber);
		reservation.setRoomId(rd);
		String name = hService.getOne((hotelId)).getName();
		Room room = rService.getRoomByIdentity(hotelId, roomNumber);

		if (result.hasErrors()) {
			return "redirect: /reservation/" + hotelId + "/" + roomNumber;
		} else if (room.isReserved()) {
			model.addAttribute("message", "The Room you are trying to reseved is booked by an other customer");
		} else {
			model.addAttribute("message", "You've Successfully Booked Room number: " + roomNumber + " @ " + name);
			room.setReserved(true);
			reservation.setStatus("Approved");
			resService.saveReservation(reservation);
			rService.saveRoom(room);
		}
		return "reserveConfirmation";
	}

//	@GetMapping("/hotel/myReservation")
//	private String myReservation(Model model, HttpSession session){
//		User user = (User) session.getAttribute("user");
//		List<Reservation> reservs  = resService.getAllReservations(user.getId());
//		if(reservs == null){
//			System.out.println("null");
//		}else{
//			System.out.println(reservs);
//		}
//		model.addAttribute("myReservations", reservs);
//		return "myReservation";
//	}
}
