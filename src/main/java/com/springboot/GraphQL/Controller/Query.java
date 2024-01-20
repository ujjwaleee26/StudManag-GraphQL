package com.springboot.GraphQL.Controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Query 
{
   @QueryMapping	
   public String firstQuery() {
	   return "First GQL Query";
   }
}
