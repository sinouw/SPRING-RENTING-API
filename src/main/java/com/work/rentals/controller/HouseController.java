package com.work.rentals.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.rentals.model.House;
import com.work.rentals.services.IHouseService;


@EnableAutoConfiguration
@RestController
@RequestMapping("/api/houses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HouseController {

	@Autowired
	IHouseService service;
	
	@GetMapping("/getall")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	Set<House> getAllHouses(){
		return service.getAllHouse();
	}
	
	@GetMapping("/getById/{id}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	House getHouseById(@PathVariable Long id){
		return service.getHouseById(id);
	}
	
	@PostMapping("/saveOrUpdate")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	House addHouse(@RequestBody House house){
		return service.saveOrUpdate(house);
	}
	
	@DeleteMapping("/DeleteHouse/{id}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	String DeleteHouse(@PathVariable Long id){
		 service.deleteHouseById(id);
		 return "House deleted id : "+id;
	}
	
	
	@PutMapping("/toggleReserved/{id}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	Boolean SetReservedHouse(@PathVariable Long id){
		return service.ToggleEnableRenting(id);
	}
	
	
	
}
