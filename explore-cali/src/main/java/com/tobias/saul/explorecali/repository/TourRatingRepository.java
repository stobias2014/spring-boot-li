package com.tobias.saul.explorecali.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tobias.saul.explorecali.domain.TourRating;
import com.tobias.saul.explorecali.domain.TourRatingPk;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends JpaRepository<TourRating, TourRatingPk> {
	
	List<TourRating> findByTourRatingPkTourTourId(Long tourId);
	
	Optional<TourRating> findByTourRatingPkTourTourIdAndTourRatingPkCustomerId(Long tourId, Long customerId);

}
