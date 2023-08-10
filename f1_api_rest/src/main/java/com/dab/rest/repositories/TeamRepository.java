package com.dab.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.rest.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
	
	@Query(value = "SELECT t FROM Team t WHERE t.name=:name")
	Team findByName(@Param("name") String name);
	
	@Query(value = "SELECT t FROM Team t WHERE t.engine=:engine")
	List<Team> findByEngine(@Param("engine") String engine);

}
