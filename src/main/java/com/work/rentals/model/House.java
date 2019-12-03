package com.work.rentals.model;


import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.work.rentals.model.auth.User;

@Entity
public class House {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String description;
	    
	    private Boolean Reserved = false;
	    
	    
	    @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "address_id", referencedColumnName = "id")
	    private Address address;

	    
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","houses","rentals"})
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private User user;
	    
	    
	    @JsonManagedReference
		@OneToMany(mappedBy = "house")
	    private Set<Renting> rentals;

		public House() {}

		public House(String description,Boolean Reserved) {
			this.description = description;
			this.Reserved=Reserved;
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

		public Address getAddresse() {
			return address;
		}

		public void setAddresse(Address address) {
			this.address = address;
		}

		public Boolean getReserved() {
			return Reserved;
		}

		public void setReserved(Boolean reserved) {
			Reserved = reserved;
		}
		
		
		  
	    public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		
		
	    
	    

	    
	    
	
}
