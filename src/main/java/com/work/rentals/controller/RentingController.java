package com.work.rentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.rentals.model.House;
import com.work.rentals.model.Renting;
import com.work.rentals.model.auth.User;
import com.work.rentals.repository.IUserRepository;
import com.work.rentals.services.IHouseService;
import com.work.rentals.services.IRentingService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/api/Rentals")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RentingController {

	@Autowired
	IRentingService service;
	
	@Autowired
	IUserRepository userrepo;
	
	@Autowired
	IHouseService houseservice;
	
	@GetMapping("/getall")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	List<Renting> getAllRentals(){
		return service.getAllRentals();
	}
	
	@GetMapping("/getById/{id}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	Renting getRentingById(@PathVariable Long id){
		return service.getRentingById(id);
	}
	
	@PostMapping("/saveOrUpdate/{userid}/{houseid}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	Renting addRenting(@RequestBody Renting renting,@PathVariable Long userid,@PathVariable Long houseid){
		
		User user = userrepo.findById(userid).get();
		House house = houseservice.getHouseById(houseid);
		
		renting.setHouse(house);
		renting.setUser(user);
		return service.saveOrUpdate(renting);
	}
	
	@DeleteMapping("/DeleteRenting/{id}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	String DeleteRenting(@PathVariable Long id){
		 service.deleteRentingById(id);
		 return "Renting deleted id : "+id;
	}
	
	
}
