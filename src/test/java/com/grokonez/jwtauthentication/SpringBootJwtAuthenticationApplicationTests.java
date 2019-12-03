package com.grokonez.jwtauthentication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.work.rentals.model.House;
import com.work.rentals.model.auth.User;
import com.work.rentals.security.services.UserDetailsServiceImpl;
import com.work.rentals.services.IHouseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJwtAuthenticationApplicationTests {

	
	@Autowired
	IHouseService service;
	
	@Autowired
	UserDetailsServiceImpl userservice;
	
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void saveHouse() {
		
	}
}
