package com.springboot.GraphQL.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.springboot.GraphQL.response.StudentResponse;
import com.springboot.GraphQL.response.StudentSubjectResponse;
import com.springboot.GraphQL.response.TeacherResponse;
import com.springboot.GraphQL.response.TeacherSubjectResponse;
import com.springboot.GraphQL.service.MemberService;
import com.springboot.GraphQL.service.ResultService;
import com.springboot.GraphQL.service.SubjectService;

@Controller
public class Query 
{
   @Autowired
   private MemberService memberService;
   
   @Autowired
   private ResultService resultService;
   
   @Autowired
   private SubjectService subjectService;
   
   	
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
   //over fetching resolved
//   @SchemaMapping(typeName = "StudentResponse",field="result")
//   public List<StudentSubjectResponse> getResultsForStudents(StudentResponse student){
//	   System.out.println(": : in graphQL resolver : :");
//	   return  resultService.getResultForStudent(student.getId());
//   }
//	   
//   problem is that , we are making n+1 calls, and we need to resolve it
//	   :: in MemberService, fetching all students ::
//		   : : in graphQL resolver : :
//		   :: in ResultService, fetching result for student : 1
//		   : : in graphQL resolver : :
//		   :: in ResultService, fetching result for student : 2
//		   : : in graphQL resolver : :
//		   :: in ResultService, fetching result for student : 3
	   
   
   //graphQL dataloader
//   batch mapping increases flexbility with calls, with max=1 , its like schema mapping 
    @BatchMapping(typeName = "StudentResponse", field = "result",maxBatchSize = 2)
    public Map<StudentResponse, List<StudentSubjectResponse>> getResultForAllStudents(List<StudentResponse> students){
    	
    	System.out.println(":: fetching results for all students");
		// single database call to fetch entire results for all students
		return resultService.getResultsForStudents(students);
    }
    
    @QueryMapping
   	public List<TeacherResponse> getAllTeachers(){
   		return memberService.getAllTeacher(); 
   	}
    
    @BatchMapping(typeName = "TeacherResponse", field = "subExp")
    public Map<TeacherResponse, List<TeacherSubjectResponse>> getSubjectForAllTeachers(List<TeacherResponse> teachers){
    	
    	System.out.println(":: fetching results for all teachers");
		// single database call to fetch entire results for all students
		return subjectService.getSubjectForTeachers(teachers);
    }
   
	   
   }

