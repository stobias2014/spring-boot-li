package com.tobias.saul.reservationservices.web.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.reservationservices.entity.Reservation;
import com.tobias.saul.reservationservices.repository.ReservationRepository;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationWebService {
	
	private final ReservationRepository reservationRepository;
	
	public ReservationWebService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	@GetMapping
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}
	
	@GetMapping("/{reservationId}")
	public Reservation getReservation(@PathVariable("reservationId") Long reservationId) {
		return reservationRepository.findById(reservationId).get();
	}

}
