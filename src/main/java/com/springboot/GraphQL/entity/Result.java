package com.springboot.GraphQL.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "result")
@IdClass(ResultID.class)
public class Result {
		
	@Id
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Member student;
		
	@Id
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private Subject subject;
		
	@Column(name = "marks")
	private double marks;

}
