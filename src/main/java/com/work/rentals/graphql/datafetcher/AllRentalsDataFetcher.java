package com.work.rentals.graphql.datafetcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.work.rentals.model.Renting;
import com.work.rentals.services.IHouseService;
import com.work.rentals.services.IRentingService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllRentalsDataFetcher implements DataFetcher<List<Renting>> {

	
	@Autowired
	IRentingService service;
	
	 @Override
	    public List<Renting> get(DataFetchingEnvironment env) {
	       return service.getAllRentals();
	    }
	 
	 
}
