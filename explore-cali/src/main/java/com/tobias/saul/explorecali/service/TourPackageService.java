package com.tobias.saul.explorecali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.explorecali.domain.TourPackage;
import com.tobias.saul.explorecali.repository.TourPackageRepository;

@Service
public class TourPackageService {
	
	private final TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourPackageService(TourPackageRepository tourPackageRepository) {
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public TourPackage createTourPackage(String code, String name) {
		return tourPackageRepository.findById(code)
				.orElse(tourPackageRepository.save(new TourPackage(code, name)));
	}
	
	public TourPackage getTourPackage(String tourPackageCode) {
		return tourPackageRepository.findById(tourPackageCode).get();
	}
	
	public Iterable<TourPackage> getAllTourPackages() {
		return tourPackageRepository.findAll();
	}
	
}
