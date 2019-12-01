package com.work.rentals.services;



import java.util.Set;

import com.work.rentals.model.Renting;


public interface IRentingService {

	Set<Renting> getAllRentals();
	
	Renting getRentingById(Long id);
	
	Renting saveOrUpdate(Renting renting);
	
	void deleteRentingById(Long id);
}
