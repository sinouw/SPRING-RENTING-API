package com.work.rentals.services;

import java.util.List;
import java.util.Set;

import com.work.rentals.model.House;


public interface IHouseService {

	List<House> getAllHouse();
	
	House getHouseById(Long id);
	
	House saveOrUpdate(House house);
	
	void deleteHouseById(Long id);
	
	Boolean ToggleEnableRenting(Long id);

	List<House> saveAll(Set<House> houses);
}
