package com.work.rentals.graphql.datafetcher;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.work.rentals.model.House;
import com.work.rentals.services.IHouseService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
@Component
public class HouseDataFetcher implements DataFetcher<House> {

	@Autowired
	IHouseService service;
	
	@Override
	public House get(DataFetchingEnvironment environment) {
		 Map args = environment.getArguments();
		return service.getHouseById(new Long(String.valueOf(args.get("id"))));
	}

}
