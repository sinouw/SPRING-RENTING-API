package com.work.rentals.graphql.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.work.rentals.graphql.utilities.GraphQlUtility;

import graphql.ExecutionResult;
import graphql.GraphQL;
import io.swagger.annotations.ApiOperation;

@RestController
public class GraphController {

	private GraphQL graphQL;
	private GraphQlUtility graphQlUtility;
	
	GraphController(GraphQlUtility graphQlUtility) throws IOException {
        this.graphQlUtility = graphQlUtility;
        graphQL = graphQlUtility.createGraphQlObject();
    }
	
	@ApiOperation(value="Pour Récuperer les maisons")
	@PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String query){
        ExecutionResult result = graphQL.execute(query);
        System.out.println("errors: "+result.getErrors());
        return ResponseEntity.ok(result.getData());
    }
}
