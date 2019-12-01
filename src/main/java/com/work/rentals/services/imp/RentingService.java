package com.work.rentals.services.imp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.work.rentals.model.Renting;
import com.work.rentals.repository.IRentingRepository;
import com.work.rentals.services.IRentingService;

public class RentingService implements IRentingService{

	@Autowired
	IRentingRepository repo;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Renting> getAllRentings() {
		return (Set<Renting>)repo.findAll();
	}

	@Override
	public Renting getRentingById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Renting saveOrUpdate(Renting renting) {
		return repo.save(renting);
	}

	@Override
	public void deleteRentingById(Long id) {
		repo.deleteById(id);
	}
	
	
}
