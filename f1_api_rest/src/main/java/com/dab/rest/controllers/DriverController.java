package com.dab.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dab.rest.dto.DriverDto;
import com.dab.rest.entities.Driver;
import com.dab.rest.entities.Team;
import com.dab.rest.services.DriverService;
import com.dab.rest.services.TeamService;

@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

	@Autowired
	private DriverService driverService;

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Driver> drivers = driverService.findAll();
		List<DriverDto> driversDto = drivers.stream().map(DriverDto::getDto).collect(Collectors.toList());
		return ResponseEntity.ok(driversDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {

		Driver driver = driverService.findById(id);

		if (driver == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Driver with id " + id + " not found");
			
		}

		DriverDto driverDto = DriverDto.getDto(driver);
		return ResponseEntity.status(HttpStatus.FOUND).body(driverDto);

	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> findByName(@PathVariable("name") String name) {
		
		List<Driver> drivers = driverService.findByName(name);
		
		if(drivers.isEmpty()) {
			Map<String, String> infoMap = new HashMap<>();
			infoMap.put("Info", "Drivers not found");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(infoMap);
		}
		List<DriverDto> driversDto = drivers.stream().map(DriverDto::getDto).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.FOUND).body(driversDto);
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Driver driver) {

		Driver driverSaved = driverService.save(driver);
		DriverDto driverDto = DriverDto.getDto(driverSaved);

		return ResponseEntity.status(HttpStatus.CREATED).body(driverDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody DriverDto driver, @PathVariable("id") Long id) {

		if (!driver.getId().equals(id)) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Ids not equals");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		}

		Driver driver1 = driverService.findById(id);

		if (driver1 == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Driver with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}

		Driver driverSaved = DriverDto.getEntity(driver);
		driverService.save(driverSaved);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		Driver driver = driverService.findById(id);

		if (driver == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Driver with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}

		driverService.delete(driver);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@RequestMapping(value = "/{id}/{team}", method = RequestMethod.PUT)
	public ResponseEntity<?> addTeam(@PathVariable("id") Long idDriver, @PathVariable("team") Long idTeam) {
		Driver driver = driverService.findById(idDriver);
		Team team = teamService.findById(idTeam);

		if (driver == null || team == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Id not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}

		driver.setTeam(team);
		driver = driverService.save(driver);
		DriverDto driverDto = DriverDto.getDto(driver);

		return ResponseEntity.status(HttpStatus.OK).body(driverDto);
	}

}
