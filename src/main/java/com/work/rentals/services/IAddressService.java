package com.work.rentals.services;



import java.util.Set;

import com.work.rentals.model.Address;

public interface IAddressService {

	Set<Address> getAllAddresses();
	
	Address getAddressById(Long id);
	
	Address saveOrUpdate(Address address);
	
	void deleteAddressById(Long id);
}
