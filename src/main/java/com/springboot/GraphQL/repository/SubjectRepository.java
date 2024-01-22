package com.springboot.GraphQL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.GraphQL.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> 
{
    List<Subject> findByTeacherId(int teacherId);
}
