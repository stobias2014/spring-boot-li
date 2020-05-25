package com.tobias.saul.roomservices.web.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.roomservices.repository.RoomRepository;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomWebService {
	
	private final RoomRepository roomRepository;
	
	public RoomWebService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	

}
