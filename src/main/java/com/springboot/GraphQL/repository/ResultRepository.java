package com.springboot.GraphQL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.GraphQL.entity.Result;
import com.springboot.GraphQL.entity.ResultID;

@Repository
public interface ResultRepository extends JpaRepository<Result, ResultID> 
{
     List<Result> findByStudentId(int studentId);
}
