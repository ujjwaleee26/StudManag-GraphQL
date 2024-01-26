package com.springboot.GraphQL.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.springboot.GraphQL.entity.MemberType;
import com.springboot.GraphQL.response.MemberResponse;
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
   public List<MemberResponse> getMembers(@Argument("filter")MemberType type){
	   return memberService.getMembers(type);
   }
	   
   @BatchMapping(typeName="MemberResponse", field="propData")
   public Map<MemberResponse,List<?>> getPropData(List<MemberResponse> members)
   {
	   List<MemberResponse> students=new ArrayList<MemberResponse>();
	   List<MemberResponse> teachers=new ArrayList<MemberResponse>();
	   Map<MemberResponse,List<?>> output=new HashMap<MemberResponse, List<?>>();
	   members.forEach(member ->{
		   if(member.getType()==MemberType.TEACHER)
			   teachers.add(member);
		   else
			   students.add(member);
	   });
	   
	   if(!students.isEmpty())
		   output.putAll(resultService.getResultsForStudents(students));
	   if(!teachers.isEmpty())
		   output.putAll(subjectService.getSubjectForTeachers(teachers));
	   return output;
   }
   
   
   }

