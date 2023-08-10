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

import com.dab.rest.dto.TeamDto;
import com.dab.rest.entities.Driver;
import com.dab.rest.entities.Team;
import com.dab.rest.services.DriverService;
import com.dab.rest.services.TeamService;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private DriverService driverService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {

		List<Team> teams = teamService.findAll();
		List<TeamDto> teamsDto = teams.stream().map(TeamDto::getDto).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(teamsDto);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {

		Team team = teamService.findById(id);

		if (team == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Team with id " + id + " not found");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}

		TeamDto teamDto = TeamDto.getDto(team);
		return ResponseEntity.status(HttpStatus.FOUND).body(teamDto);

	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Team team){
		
		Team teamSaved = teamService.save(team);
		TeamDto teamDto = TeamDto.getDto(teamSaved);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(teamDto);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update( @RequestBody TeamDto teamDto, @PathVariable("id") Long id){
		
		if(!teamDto.getId().equals(id)) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Ids not equals");
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		}
		
		Team team1 = teamService.findById(id);
		if(team1 == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Team with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		Team teamSaved = TeamDto.getEntity(teamDto);
		teamService.save(teamSaved);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		Team team = teamService.findById(id);
		
		if(team == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Team with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		teamService.delete(team);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	@RequestMapping(value = "/{idTeam}/{idDriver}", method = RequestMethod.PUT)
	public ResponseEntity<?> addDriver(@PathVariable("idTeam") Long idTeam, @PathVariable("idDriver") Long idDriver) {
		
		Driver driver = driverService.findById(idDriver);
		Team team = teamService.findById(idTeam);
		
		if(driver == null || team == null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("Error", "Id not foud");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		team.getDrivers().add(driver);
		team = teamService.save(team);
		TeamDto teamDto = TeamDto.getDto(team);
		
		return ResponseEntity.status(HttpStatus.OK).body(teamDto);
		
	}
 
}
