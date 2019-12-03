package com.work.rentals.graphql.datafetcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.work.rentals.model.House;
import com.work.rentals.services.IHouseService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllHousesDataFetcher implements DataFetcher<List<House>> {

	
	@Autowired
	IHouseService service;
	
	 @Override
	    public List<House> get(DataFetchingEnvironment env) {
	       return service.getAllHouse();
	    }
	 
	 
}
