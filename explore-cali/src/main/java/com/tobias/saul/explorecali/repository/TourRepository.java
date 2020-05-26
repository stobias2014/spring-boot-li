package com.tobias.saul.explorecali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tobias.saul.explorecali.domain.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
	
	List<Tour> findByTourPackageCode(@Param("code") String code);

}
