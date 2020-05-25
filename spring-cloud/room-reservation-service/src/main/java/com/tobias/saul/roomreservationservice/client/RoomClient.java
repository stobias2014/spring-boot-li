package com.tobias.saul.roomreservationservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tobias.saul.roomreservationservice.model.Room;

@FeignClient("roomservices")
public interface RoomClient {
	
	@GetMapping("/api/v1/rooms")
	public List<Room> getAllRooms();
	
	@GetMapping("/api/v1/rooms/{roomId}")
	public Room getRoom(@PathVariable("roomId") Long roomId);
}
