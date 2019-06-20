package edu.mum.cs544.controller;

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
import edu.mum.cs544.bean.*;
import edu.mum.cs544.service.HotelService;
import edu.mum.cs544.service.RoomService;

@Controller
@RequestMapping("/hotel/room")
public class RoomController {

	@Autowired
	private HotelService hService;

	@Autowired
	private RoomService rService;

	@GetMapping("/add")
	private String addHotelRoom(@ModelAttribute("room") Room room, Model model) {
		model.addAttribute("hotels", hService.getAll());
		return "addHotelRoomForm";
	}

	@PostMapping("/add")
	private String addHotelRoom(@Valid @ModelAttribute("room") Room room, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addHotelRoomForm";
		}
		rService.saveRoom(room);
		long hotelId = room.getRoomId().getHotelId();
		return "redirect:/hotel/"+hotelId+"/rooms";
	}

	@GetMapping("/update/{id}")
	public String update(@ModelAttribute("room") Room room, @PathVariable long id, Model model) {
		model.addAttribute("ht", hService.getOne(id));
		return "updateHotelForm";
	}

	@PostMapping("/update/{id}")
	private String updateHotel(@Valid @ModelAttribute("room") Room room, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/hotel/update/{id}";
		}
		rService.saveRoom(room);
		return "redirect:/hotel/list";
	}

//	@GetMapping("/delete/{id}")
//	private String delete(@PathVariable long id, Model model) {
//		model.addAttribute("hotel", hService.get(id));
//		return "deleteHotelForm";
//	}
}
