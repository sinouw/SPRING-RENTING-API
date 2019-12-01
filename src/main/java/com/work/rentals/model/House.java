package com.work.rentals.model;


import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import javax.persistence.Id;

@Entity
public class House {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String description;
	    
	    private Address adresse;

	    @OneToMany(mappedBy = "house")
	    private Set<Renting> rentals;

		public House() {}

		public House(String description) {

			this.description = description;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Set<Renting> getRentals() {
			return rentals;
		}

		public void setRentals(Set<Renting> rentals) {
			this.rentals = rentals;
		}
		
		
		
		
		
	    
	    

	    
	    
	
}
