package com.springboot.GraphQL.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentSubjectResponse extends SubjectResponse
{
    private String subjectName;
    private double marks;
}
