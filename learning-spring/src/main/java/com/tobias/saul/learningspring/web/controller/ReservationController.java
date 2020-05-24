package com.tobias.saul.learningspring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.learningspring.data.entity.Reservation;
import com.tobias.saul.learningspring.data.repository.ReservationRepository;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {
	
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationController(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	@GetMapping("/reservations")
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

}
