package com.work.rentals.graphql.utilities;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.work.rentals.graphql.datafetcher.AllHousesDataFetcher;
import com.work.rentals.graphql.datafetcher.HouseDataFetcher;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphQlUtility  {

    @Value("classpath:schemas.graphqls")
    private Resource schemaResource;
    private GraphQL graphQL;

    	private AllHousesDataFetcher allHousesDataFetcher;
    	private HouseDataFetcher houseDataFetcher;
    
    	@Autowired
    	GraphQlUtility(AllHousesDataFetcher allHousesDataFetcher,
    			HouseDataFetcher houseDataFetcher)throws IOException{
    		this.allHousesDataFetcher=allHousesDataFetcher;
    		this.houseDataFetcher=houseDataFetcher;
    		
    	}

    @PostConstruct
    public GraphQL createGraphQlObject() throws IOException {
        //faire appel au fichier contenant les schemas
    	File schemas = schemaResource.getFile();
        
        
        /*
         * TypeDefinitionRegistry contient l'ensemble des définitions de type provenant
         * de la compilation d'un fichier de définition de schéma "graphql" via "SchemaParser.parse (String)".
         * 
         * */
    	TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        
    	//A runtime wiring is a specification of data fetchers
    	RuntimeWiring wiring = buildRuntimeWiring();
    	
    	//la creation du schema
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
       
        //nous obtenons ici l'objet "graphql" pour l'exécution de nos requêtes futures
        return  newGraphQL(schema).build();
    }

    public RuntimeWiring buildRuntimeWiring(){
        return newRuntimeWiring()
//                .type("Query", typeWiring -> typeWiring
//                    .dataFetcher("users", allUsersDataFetcher)
//                    .dataFetcher("user", userDataFetcher))
//                .type("User", typeWiring -> typeWiring
//                    .dataFetcher("articles", articlesDataFetcher)
//                    .dataFetcher("friends", allUsersDataFetcher))
        		.type("Query", typeWiring -> typeWiring
        				.dataFetcher("houses", allHousesDataFetcher)
        				.dataFetcher("house", houseDataFetcher)
        				)
                .build();
    }
}
