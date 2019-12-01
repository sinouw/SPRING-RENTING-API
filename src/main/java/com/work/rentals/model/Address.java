package com.work.rentals.model;

import javax.persistence.*;

@Entity
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	private String langitude;
	private String lattitude;
		
		
		@OneToOne(mappedBy = "address")
	    private House house;
	
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	public Address(String langitude, String lattitude, House house) {
			super();
			this.langitude = langitude;
			this.lattitude = lattitude;
			this.house = house;
		}


	public House getHouse() {
			return house;
		}

		public void setHouse(House house) {
			this.house = house;
		}

	public String getLangitude() {
		return langitude;
	}
	public void setLangitude(String langitude) {
		this.langitude = langitude;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
