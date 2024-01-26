package com.springboot.GraphQL.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.GraphQL.entity.Subject;
import com.springboot.GraphQL.repository.SubjectRepository;
import com.springboot.GraphQL.response.MemberResponse;
import com.springboot.GraphQL.response.TeacherSubjectResponse;

@Service
public class SubjectService {
      
	@Autowired
	private SubjectRepository repository;
	
//	public List<TeacherSubjectResponse> getSubjectForTeacher(int teacherId)
//	{
//	List<Subject> subjects=repository.findByTeacherId(teacherId);
//	List<TeacherSubjectResponse> responses=new ArrayList<TeacherSubjectResponse>();
//	for(Subject subject:subjects) {
//		TeacherSubjectResponse res=new TeacherSubjectResponse();
//		res.setSubjectId(subject.getId());
//		res.setSubjectName(subject.getSubjectName());
//		res.setExperience(subject.getExperience());
//		responses.add(res);
//	}
//	return responses;
//	}
	
	public Map<MemberResponse,List<?>> getSubjectForTeachers(List<MemberResponse> responses){
		List<Subject> subjects=repository.findAll();
		 Map<MemberResponse,List<?>> batchingMap=new HashMap<>();
		 for(MemberResponse response:responses) {
			 List<TeacherSubjectResponse> tsResponse=new ArrayList<TeacherSubjectResponse>();
			 for(Subject subject:subjects) {
				 if(response.getId()==subject.getTeacher().getId()) {
					 TeacherSubjectResponse res=new TeacherSubjectResponse();
					 res.setSubjectId(subject.getId());
					 res.setSubjectName(subject.getSubjectName());
					 res.setExperience(subject.getExperience());
					 tsResponse.add(res);
				 }
			 }
			 batchingMap.put(response, tsResponse);
		 }
		 return batchingMap;
	}
}
