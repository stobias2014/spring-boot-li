package com.tobias.saul.learningspring.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobias.saul.learningspring.business.domain.RoomReservation;
import com.tobias.saul.learningspring.business.service.ReservationService;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
	
	private final ReservationService reservationService;
	
	public RoomReservationWebController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public String roomReservationsView(Model model) {
		
		List<RoomReservation> roomReservations = reservationService.getAllRoomReservations();
		model.addAttribute("roomReservations", roomReservations);
		
		return "reservations";
	}

}
