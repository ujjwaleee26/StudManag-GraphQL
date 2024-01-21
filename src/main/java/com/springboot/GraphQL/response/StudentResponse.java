package com.springboot.GraphQL.response;

import java.util.List;

import lombok.Data;

@Data
public class StudentResponse
{
   private int id;
   
   private String name;
   
   private String contact;
   
   private List<StudentSubjectResponse> result;
}
