package com.tobias.saul.explorecali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.explorecali.domain.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

}
