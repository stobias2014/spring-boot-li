package com.tobias.saul.learningspring.web.controller;

import org.springframework.ui.Model;

import com.tobias.saul.learningspring.business.service.ReservationService;

public class RoomReservationWebController {
	
	private final ReservationService reservationService;
	
	public RoomReservationWebController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	public String roomReservationsView(Model model) {
		
		return "roomreservations";
	}

}
