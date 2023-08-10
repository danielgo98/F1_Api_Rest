package com.dab.rest.services;

import java.util.List;

import com.dab.rest.entities.Driver;

public interface DriverService {
	
	List<Driver> findAll();
	
	Driver findById(Long id);
	
	List<Driver> findByName(String firstName);
	
	Driver findByNumber(Integer number);
	
	List<Driver> findDriversByTeam(String team);
	
	Driver save (Driver driver);
	
	void delete(Driver driver);

}
