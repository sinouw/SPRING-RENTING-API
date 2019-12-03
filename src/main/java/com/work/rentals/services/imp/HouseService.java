package com.work.rentals.services.imp;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.rentals.model.House;
import com.work.rentals.repository.IHouseRepository;
import com.work.rentals.services.IHouseService;


@Service
public class HouseService implements IHouseService{

	@Autowired
	IHouseRepository repo;

	@Override
	public List<House> getAllHouse() {
		return (List<House>) repo.findAll();
	}

	@Override
	public House getHouseById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public House saveOrUpdate(House house) {
		return repo.save(house);
	}

	@Override
	public void deleteHouseById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Boolean ToggleEnableRenting(Long id) {
		House house = repo.findById(id).get();
		house.setReserved(!house.getReserved());
		return house.getReserved();
	}


	@Override
	public List<House> saveAll(Set<House> houses) {
		return (List<House>) repo.saveAll(houses);
	}
}
