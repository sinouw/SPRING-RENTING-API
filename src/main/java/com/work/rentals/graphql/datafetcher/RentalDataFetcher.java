package com.work.rentals.graphql.datafetcher;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.work.rentals.model.Renting;
import com.work.rentals.services.IRentingService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
@Component
public class RentalDataFetcher implements DataFetcher<Renting> {

	@Autowired
	IRentingService service;
	
	@Override
	public Renting get(DataFetchingEnvironment environment) {
		 Map args = environment.getArguments();
		return service.getRentingById(new Long(String.valueOf(args.get("id"))));
	}

}
