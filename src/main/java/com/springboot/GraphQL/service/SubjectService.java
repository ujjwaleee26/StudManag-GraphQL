package com.springboot.GraphQL.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.GraphQL.entity.Subject;
import com.springboot.GraphQL.repository.SubjectRepository;
import com.springboot.GraphQL.response.TeacherResponse;
import com.springboot.GraphQL.response.TeacherSubjectResponse;

@Service
public class SubjectService {
      
	@Autowired
	private SubjectRepository repository;
	
	public List<TeacherSubjectResponse> getSubjectForTeacher(int teacherId)
	{
	List<Subject> subjects=repository.findByTeacherId(teacherId);
	List<TeacherSubjectResponse> responses=new ArrayList<TeacherSubjectResponse>();
	for(Subject subject:subjects) {
		TeacherSubjectResponse res=new TeacherSubjectResponse();
		res.setSubjectId(subject.getId());
		res.setSubjectName(subject.getSubjectName());
		res.setExperience(subject.getExperience());
		responses.add(res);
	}
	return responses;
	}
	
	public Map<TeacherResponse,List<TeacherSubjectResponse>> getSubjectForTeachers(List<TeacherResponse> responses){
		List<Subject> subjects=repository.findAll();
		 Map<TeacherResponse,List<TeacherSubjectResponse>> batchingMap=new HashMap<>();
		 for(TeacherResponse response:responses) {
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
