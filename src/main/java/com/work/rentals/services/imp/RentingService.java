package com.work.rentals.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.rentals.model.Renting;
import com.work.rentals.repository.IRentingRepository;
import com.work.rentals.services.IRentingService;

@Service
public class RentingService implements IRentingService{

	@Autowired
	IRentingRepository repo;

	@Override
	public List<Renting> getAllRentals() {
		return repo.findAll();
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
