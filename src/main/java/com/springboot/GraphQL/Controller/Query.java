package com.springboot.GraphQL.Controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Query 
{
   @QueryMapping	
   public String firstQuery() {
	   return "First GQL Query";
   }
   
   @QueryMapping
   public String secondQuery(@Argument String firstName,@Argument String lastName) {
	   return firstName+" "+lastName;
   }
}
