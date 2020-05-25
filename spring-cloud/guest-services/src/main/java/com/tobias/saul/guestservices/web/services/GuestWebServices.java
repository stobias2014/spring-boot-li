package com.tobias.saul.guestservices.web.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.guestservices.entity.Guest;
import com.tobias.saul.guestservices.repository.GuestRepository;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestWebServices {
	
	private final GuestRepository guestRepository;
	
	public GuestWebServices(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
	
	@GetMapping
	public List<Guest> getAllGuests() {
		return guestRepository.findAll();
	}
	
	@GetMapping("/{guestId}")
	public Guest getGuestById(@PathVariable("guestId") Long guestId) {
		return guestRepository.findById(guestId).get();
	}
	
	

}
