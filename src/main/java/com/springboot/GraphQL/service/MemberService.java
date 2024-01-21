package com.springboot.GraphQL.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.GraphQL.entity.Member;
import com.springboot.GraphQL.entity.MemberType;
import com.springboot.GraphQL.repository.MemberRepository;
import com.springboot.GraphQL.response.StudentResponse;

@Service 
public class MemberService {
	
	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private ResultService resultService;
	
	public List<StudentResponse> getAllStudent(){
		System.out.println(":: in MemberService, fetching all students ::");
	    List<Member> students=repository.findByType(MemberType.STUDENT.toString());
	    List<StudentResponse> responses=new ArrayList<StudentResponse>();
	    for(Member student:students) {
	    	StudentResponse studentRes=new StudentResponse();
	    	studentRes.setId(student.getId());
	    	studentRes.setName(student.getFirstName()+" "+student.getLastName());
			studentRes.setContact(student.getContact());
			studentRes.setResult(resultService.getResultForStudent(student.getId()));
			responses.add(studentRes);
	    }
	    return responses;
	}

}
