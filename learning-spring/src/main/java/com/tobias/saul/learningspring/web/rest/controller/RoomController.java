package com.tobias.saul.learningspring.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.learningspring.data.entity.Room;
import com.tobias.saul.learningspring.data.repository.RoomRepository;

@RestController
@RequestMapping("/api/v1")
public class RoomController {
	
	private final RoomRepository roomRepository;
	
	@Autowired
	public RoomController(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

}
