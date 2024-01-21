package com.springboot.GraphQL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.GraphQL.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> 
{
	List<Member> findByType(String type);
}
