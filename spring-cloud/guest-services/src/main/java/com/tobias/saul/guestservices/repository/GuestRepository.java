package com.tobias.saul.guestservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.guestservices.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{

}
