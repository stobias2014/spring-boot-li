package com.tobias.saul.roomservices.web.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.roomservices.entity.Room;
import com.tobias.saul.roomservices.repository.RoomRepository;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomWebService {
	
	private final RoomRepository roomRepository;
	
	public RoomWebService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	@GetMapping
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	@GetMapping("/{roomId}")
	public Room getRoom(@PathVariable("roomId") Long roomId) {
		return roomRepository.findById(roomId).get();
	}
}
