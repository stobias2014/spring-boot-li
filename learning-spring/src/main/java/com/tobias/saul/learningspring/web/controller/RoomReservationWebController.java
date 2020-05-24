package com.tobias.saul.learningspring.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobias.saul.learningspring.business.domain.RoomReservation;
import com.tobias.saul.learningspring.business.service.ReservationService;
import com.tobias.saul.learningspring.web.util.DateUtils;

@Controller
@RequestMapping("reservations")
public class RoomReservationWebController {
	
	private final ReservationService reservationService;
	
	public RoomReservationWebController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping("/{date}")
	public String roomReservationsView(Model model, @PathVariable("date") String dateString) {
		
		Date date = DateUtils.createDateFromDateString(dateString);
		
		List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		
		return "reservations";
	}

}
