package com.work.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.rentals.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {

}
