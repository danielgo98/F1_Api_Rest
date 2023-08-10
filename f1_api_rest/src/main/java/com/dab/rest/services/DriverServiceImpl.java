package com.dab.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dab.rest.entities.Driver;
import com.dab.rest.repositories.DriverRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverRepository driverRepository;

	@Override
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}

	@Override
	public Driver findById(Long id) {
		Optional<Driver> driver = driverRepository.findById(id);
		return driver.isPresent() ? driver.get() : null;
	}

	@Override
	public Driver findByName(String firstName) {
		Driver driver = driverRepository.findByName(firstName);
		return driver == null ? null : driver;
	}

	@Override
	public Driver findByNumber(Integer number) {
		Driver driver = driverRepository.findByNumber(number);
		return driver == null ? null : driver;
	}

	@Override
	public List<Driver> findDriversByTeam(String team) {
		return driverRepository.findDriversByTeam(team);
	}

	@Override
	public Driver save(Driver driver) {
		driver = driverRepository.save(driver);
		return driver;
	}

	@Override
	public void delete(Driver driver) {
		driverRepository.delete(driver);
	}


}
