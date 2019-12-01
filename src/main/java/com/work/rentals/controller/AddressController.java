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

import com.work.rentals.model.Address;
import com.work.rentals.services.IAddressService;


@EnableAutoConfiguration
@RestController
@RequestMapping("/api/Addresses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {

	@Autowired
	IAddressService service;
	
	@GetMapping("/getall")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	Set<Address> getAllAddresss(){
		return service.getAllAddresses();
	}
	
	@GetMapping("/getById/{id}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	Address getAddressById(@PathVariable Long id){
		return service.getAddressById(id);
	}
	
	@PostMapping("/saveOrUpdate")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	Address addAddress(@RequestBody Address address){
		return service.saveOrUpdate(address);
	}
	
	@DeleteMapping("/DeleteAddress/{id}")
	@CrossOrigin(origins = "http://localhost:8082", allowedHeaders = "*")
	String DeleteAddress(@PathVariable Long id){
		 service.deleteAddressById(id);
		 return "Address deleted id : "+id;
	}
	
	
}
