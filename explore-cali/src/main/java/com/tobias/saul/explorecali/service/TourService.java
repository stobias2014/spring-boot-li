package com.tobias.saul.explorecali.service;

import org.springframework.stereotype.Service;

import com.tobias.saul.explorecali.domain.Difficulty;
import com.tobias.saul.explorecali.domain.Region;
import com.tobias.saul.explorecali.domain.Tour;
import com.tobias.saul.explorecali.domain.TourPackage;
import com.tobias.saul.explorecali.repository.TourPackageRepository;
import com.tobias.saul.explorecali.repository.TourRepository;

@Service
public class TourService {

	private final TourPackageRepository tourPackageRepository;
	private final TourRepository tourRepository;

	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}

	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {
		
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
		
		return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
		
	}
	
	public long getTotalTourCount() {
		return tourRepository.count();
	}

}
