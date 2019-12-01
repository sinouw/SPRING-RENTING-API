package com.work.rentals.services.imp;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import com.work.rentals.model.Address;
import com.work.rentals.repository.IAddressRepository;
import com.work.rentals.services.IAddressService;

public class AddressService implements IAddressService{

	@Autowired
	IAddressRepository repo;
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Address> getAllAddresses() {
		return (Set<Address>)repo.findAll();
	}

	@Override
	public Address getAddressById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Address saveOrUpdate(Address address) {
		return repo.save(address);
	}

	@Override
	public void deleteAddressById(Long id) {
		repo.deleteById(id);
	}

}
