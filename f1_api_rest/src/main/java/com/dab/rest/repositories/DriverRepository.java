package com.dab.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.rest.entities.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{
	
	@Query(value = "SELECT d FROM Driver d WHERE d.firstName=:name")
	Driver findByName(@Param("name") String name);
	
	@Query(value = "SELECT d FROM Driver d WHERE d.number=:number")
	Driver findByNumber(@Param("number") Integer number);
	
	@Query(value = "SELECT d FROM Driver d LEFT JOIN fetch d.team t WHERE t.name=:name")
	List<Driver> findDriversByTeam(@Param("name") String name);

}
