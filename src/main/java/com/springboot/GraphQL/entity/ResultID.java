package com.springboot.GraphQL.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultID implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private Member student;
	
	private Subject subject;
}
