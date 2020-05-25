package com.tobias.saul.roomservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.roomservices.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
}
