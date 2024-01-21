package com.springboot.GraphQL.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.springboot.GraphQL.response.StudentResponse;
import com.springboot.GraphQL.response.StudentSubjectResponse;
import com.springboot.GraphQL.service.MemberService;
import com.springboot.GraphQL.service.ResultService;

@Controller
public class Query 
{
   @Autowired
   private MemberService memberService;
   
   @Autowired
   private ResultService resultService;
   
   	
   @QueryMapping	
   public String firstQuery() {
	   return "First GQL Query";
   }
   
   @QueryMapping
   public String secondQuery(@Argument String firstName,@Argument String lastName) {
	   return firstName+" "+lastName;
   }
   
   @QueryMapping
   public List<StudentResponse> getAllStudents(){
	   return memberService.getAllStudent();
   }
   
   //implement graphQL resolver or data fetcher 
   @SchemaMapping(typeName = "StudentResponse",field="result")
   public List<StudentSubjectResponse> getResultsForStudents(StudentResponse student){
	   System.out.println(": : in graphQL resolver : :");
	   return  resultService.getResultForStudent(student.getId());
	   
   }
}
