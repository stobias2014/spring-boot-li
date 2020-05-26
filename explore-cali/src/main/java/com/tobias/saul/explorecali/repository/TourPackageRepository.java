package com.tobias.saul.explorecali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.tobias.saul.explorecali.domain.TourPackage;

@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends JpaRepository<TourPackage, String>{

	TourPackage findByName(String tourPackageName);

	@Override
	@RestResource(exported = false)
	<S extends TourPackage> S save(S entity); 

	@Override
	@RestResource(exported = false)
	void deleteById(String id);

	@Override
	@RestResource(exported = false)
	void delete(TourPackage entity);
	
	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends TourPackage> entities); 

	@Override
	@RestResource(exported = false)
	void deleteAll();
	
	

}
