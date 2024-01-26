package com.springboot.GraphQL.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherSubjectResponse extends SubjectResponse 
{
   
   private String subjectName;
   
   private int experience;
}
