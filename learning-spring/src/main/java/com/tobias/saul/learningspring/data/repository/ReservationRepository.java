package com.tobias.saul.learningspring.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.learningspring.data.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	List<Reservation> findAllByReservationDate(Date date);
}
