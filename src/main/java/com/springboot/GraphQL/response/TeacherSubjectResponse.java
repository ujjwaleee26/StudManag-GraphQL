package com.springboot.GraphQL.response;

import lombok.Data;

@Data
public class TeacherSubjectResponse 
{
   private int subjectId;
   
   private String subjectName;
   
   private int experience;
}
