package com.springboot.GraphQL.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="subject")
public class Subject
{
   @Id
   @Column(name="id")
   private int id;
   
   @Column(name="subject_name")
   private String subjectName;
   
   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="teacher_id",referencedColumnName = "id")
   private Member teacher;
   
   @Column(name="experience")
   private int experience;
   
}
