package com.tobias.saul.learningspring.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.learningspring.data.entity.Guest;
import com.tobias.saul.learningspring.data.repository.GuestRepository;

@RestController
@RequestMapping("/api/v1")
public class GuestController {
	
	private final GuestRepository guestRepository;
	
	public GuestController(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
	
	@GetMapping("/guests")
	public List<Guest> getAllGuests() {
		return guestRepository.findAll();
	}

}
