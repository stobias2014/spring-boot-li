package com.tobias.saul.reservationservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.reservationservices.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
