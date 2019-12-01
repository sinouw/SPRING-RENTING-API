package com.work.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.rentals.model.House;

public interface IHouseRepository extends JpaRepository<House, Long> {

}
