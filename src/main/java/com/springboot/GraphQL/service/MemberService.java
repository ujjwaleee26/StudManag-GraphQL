package com.springboot.GraphQL.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.GraphQL.entity.Member;
import com.springboot.GraphQL.entity.MemberType;
import com.springboot.GraphQL.repository.MemberRepository;
import com.springboot.GraphQL.response.MemberResponse;

@Service 
public class MemberService {
	
	@Autowired
	private MemberRepository repository;
	
//	public List<StudentResponse> getAllStudent(){
//		System.out.println(":: in MemberService, fetching all students ::");
//	    List<Member> students=repository.findByType(MemberType.STUDENT.toString());
//	    List<StudentResponse> responses=new ArrayList<StudentResponse>();
//	    for(Member student:students) {
//	    	StudentResponse studentRes=new StudentResponse();
//	    	studentRes.setId(student.getId());
//	    	studentRes.setName(student.getFirstName()+" "+student.getLastName());
//			studentRes.setContact(student.getContact());
////			to resolve usage on demand , we will create query resolver
////			studentRes.setResult(resultService.getResultForStudent(student.getId()));
//			responses.add(studentRes);
//	    }
//	    return responses;
//	}
//	
//	public List<TeacherResponse> getAllTeacher(){
//		System.out.println(":: in MemberService, fetching all teachers ::");
//		List<Member> teachers=repository.findByType(MemberType.TEACHER.toString());
//		List<TeacherResponse> responses=new ArrayList<TeacherResponse>();
//		for(Member teacher:teachers) {
//			TeacherResponse teacherRes=new TeacherResponse();
//			teacherRes.setId(teacher.getId());
//			teacherRes.setName(teacher.getFirstName()+" "+teacher.getLastName());
//			teacherRes.setContact(teacher.getContact());
//			responses.add(teacherRes);
//		}
//		return responses;
//		
//	}
	
	public List<MemberResponse> getMembers(MemberType type){
		List<Member> members=null;
		if (type==null)
		{
			members=repository.findAll();
		}
		else
		{
			members=repository.findByType(type.toString());
		}
		List<MemberResponse> responses=new ArrayList<MemberResponse>();
		for(Member member:members) {
			MemberResponse memberRes=new MemberResponse();
			memberRes.setId(member.getId());
			memberRes.setName(member.getFirstName()+" "+member.getLastName());
			memberRes.setContact(member.getContact());
			memberRes.setType(MemberType.valueOf(member.getType().toUpperCase()));
			responses.add(memberRes);
		}
		return responses;
		
	}

}
