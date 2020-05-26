package com.tobias.saul.explorecali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.explorecali.domain.TourPackage;

@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, String>{

	TourPackage findByName(String tourPackageName);

}
