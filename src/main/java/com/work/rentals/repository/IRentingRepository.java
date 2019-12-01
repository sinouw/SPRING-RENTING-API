package com.work.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.rentals.model.Renting;

public interface IRentingRepository extends JpaRepository<Renting, Long> {

}
