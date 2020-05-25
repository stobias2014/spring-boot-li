package com.tobias.saul.roomreservationservice.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tobias.saul.roomreservationservice.client.RoomClient;
import com.tobias.saul.roomreservationservice.dto.RoomReservation;
import com.tobias.saul.roomreservationservice.model.Room;

@RestController
@RequestMapping("/api/v1/room-reservations")
public class RoomReservationWebService {
	
	private final RoomClient roomClient;
	
	public RoomReservationWebService(RoomClient roomClient) {
		this.roomClient = roomClient;
	}
	
	@GetMapping
	public List<RoomReservation> getRoomReservations() {
		List<Room> rooms = getAllRooms();
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getRoomId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservations.add(roomReservation);
		});
		return roomReservations;
	}
	
	public List<Room> getAllRooms() {
		ResponseEntity<List<Room>> roomResponse = restTemplate.exchange("http://ROOMSERVICES/api/v1/rooms",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {});
		return roomResponse.getBody();
	}

}
