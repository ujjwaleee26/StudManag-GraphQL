package com.springboot.GraphQL.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="member")
public class Member 
{
   @Id
   @Column(name="id")
   private int id;
   
   @Column(name="first_name")
   private String firstName;
   
   @Column(name="last_name")
   private String lastName;
   
   @Column(name="type")
   private String type;
   
   @Column(name="contact")
   private String contact;
}
