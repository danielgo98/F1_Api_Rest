package com.dab.rest.dto;

import java.util.HashSet;
import java.util.Set;

import com.dab.rest.entities.Driver;
import com.dab.rest.entities.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class TeamDto {

	private Long id;
	private String name;
	private String engine;
	private Set<Driver> drivers = new HashSet<>();

	public TeamDto() {
	}

	public TeamDto(String name, String engine) {
		this.name = name;
		this.engine = engine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public Set<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public static Team getEntity(TeamDto teamDto) {
		
		Team team = new Team(teamDto.getName(), teamDto.getEngine());
		
		if(team != null) {
			team.setId(teamDto.getId());
		}
		
		team.setDrivers(teamDto.getDrivers());
		
		return team;
		
	}
	
	public static TeamDto getDto(Team team) {
		
		TeamDto teamDto = new TeamDto(team.getName(), team.getEngine());
		
		teamDto.setId(team.getId());
		teamDto.setDrivers(team.getDrivers());
		
		return teamDto;
		
	}

	@Override
	public String toString() {
		return "TeamDto [id=" + id + ", name=" + name + ", engine=" + engine + ", drivers=" + drivers + "]";
	}

}
