package com.work.rentals.model;

import javax.persistence.*;

import javax.persistence.Id;

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
	
	  	@Id
	    @ManyToOne
	    @JoinColumn(name = "house_id")
	    private House house;
	  	
	  	@Id
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
	
	  	@Column(name = "start_date")
	    private Date startDate;
	  	
	  	@Column(name = "end_date")
	    private Date endDate;

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
