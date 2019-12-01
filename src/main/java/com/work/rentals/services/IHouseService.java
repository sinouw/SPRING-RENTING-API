package com.work.rentals.services;

import java.util.Set;

import com.work.rentals.model.House;


public interface IHouseService {

	Set<House> getAllHouse();
	
	House getHouseById(Long id);
	
	House saveOrUpdate(House house);
	
	void deleteHouseById(Long id);
	
	Boolean ToggleEnableRenting(Long id);

	Set<House> saveAll(Set<House> houses);
}
