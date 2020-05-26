package com.tobias.saul.explorecali.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tobias.saul.explorecali.domain.Tour;

@Repository
public interface TourRepository extends PagingAndSortingRepository<Tour, Long> {
	
	Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

}
