package com.work.rentals.dataLoader;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.work.rentals.model.auth.Role;
import com.work.rentals.model.auth.RoleName;
import com.work.rentals.repository.IRoleRepository;

//uncomment this just for the first time you oppen the project ^^ 
//@Component
public class DataLoader {

	@Autowired
	IRoleRepository roleRepository;
	
	//It logs a simple informational message.
	 @PostConstruct
	    private void generateData(){
	    
		 Set<Role> roles = new HashSet<>();
		 
		 Optional<Role> ownerRole = roleRepository.findByName(RoleName.ROLE_ADMIN); 
		 Optional<Role> adminRole = roleRepository.findByName(RoleName.ROLE_OWNER);
		 Optional<Role> userRole  = roleRepository.findByName(RoleName.ROLE_USER);
		
		 if(adminRole.isPresent())
		 {
			 Role role = new Role(RoleName.ROLE_ADMIN);
			 roles.add(role);
			 roleRepository.save(role);
		 }
	 
		 if(ownerRole.isPresent())
		 {
			 Role role = new Role(RoleName.ROLE_OWNER);
			 roles.add(role);
			 roleRepository.save(role);
		 }
		 
		 if(userRole.isPresent())
		 {
			 Role role = new Role(RoleName.ROLE_USER);
			 roles.add(role);
			 roleRepository.save(role);
		 }
		 
		 
	 
	 }
	 
	 
}


