package com.tobias.saul.learningspring.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.learningspring.business.domain.RoomReservation;
import com.tobias.saul.learningspring.data.entity.Reservation;
import com.tobias.saul.learningspring.data.repository.GuestRepository;
import com.tobias.saul.learningspring.data.repository.ReservationRepository;
import com.tobias.saul.learningspring.data.repository.RoomRepository;

@Service
public class ReservationService {
	
	//private final RoomRepository roomRepository;
	//private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService(ReservationRepository reservationRepository) {
		//this.roomRepository = roomRepository;
		//this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<RoomReservation> getRoomReservationsForDate(Date date) {
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		List<Reservation> reservations = reservationRepository.findAllByReservationDate(new java.sql.Date(date.getTime()));
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(reservation.getRoom().getRoomId());
			roomReservation.setRoomName(reservation.getRoom().getRoomName());
			roomReservation.setRoomNumber(reservation.getRoom().getRoomNumber());
			roomReservation.setGuestId(reservation.getGuest().getGuestId());
			roomReservation.setFirstName(reservation.getGuest().getFirstName());
			roomReservation.setLastName(reservation.getGuest().getLastName());
			roomReservations.add(roomReservation);
		});
		return roomReservations;
	}
	
	
	
}
