package com.work.rentals.model;

import javax.persistence.*;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.work.rentals.model.auth.User;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class Renting implements Serializable {
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","rentals"})
	    @ManyToOne
	    @JoinColumn(name = "house_id")
	    private House house;
	  	
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","rentals"})
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	
	  	@Column(name = "start_date")
	    private Date startDate;
	  	
	  	@Column(name = "end_date")
	    private Date endDate;
	  	
	  	@Column(name = "price")
	    private Double price;

		public Renting(Date startDate, Date endDate, Double price) {
			this.startDate = startDate;
			this.endDate = endDate;
			this.price = price;
		}

		public Renting() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public House getHouse() {
			return house;
		}

		public void setHouse(House house) {
			this.house = house;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	  	
	  	
	  	

}
