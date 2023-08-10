package com.dab.rest.services;

import java.util.List;

import com.dab.rest.entities.Team;

public interface TeamService {
	
	List<Team> findAll();
	
	Team findById(Long id);

	Team findByName(String name);

	List<Team> findByEngine(String engine);
	
	Team save (Team team);
	
	void delete (Team team);

}
