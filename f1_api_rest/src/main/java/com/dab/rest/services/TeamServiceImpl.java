package com.dab.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.rest.entities.Team;
import com.dab.rest.repositories.TeamRepository;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	TeamRepository teamRepository;

	@Override
	public List<Team> findAll() {
		return teamRepository.findAll();
	}

	@Override
	public Team findById(Long id) {
		Optional<Team> optTeam = teamRepository.findById(id);
		return optTeam.isPresent() ? optTeam.get() : null;
	}

	@Override
	public Team findByName(String name) {
		return teamRepository.findByName(name);
	}

	@Override
	public List<Team> findByEngine(String engine) {
		return teamRepository.findByEngine(engine);
	}

	@Override
	public Team save(Team team) {
		team = teamRepository.save(team);
		return team;
	}

	@Override
	public void delete(Team team) {
		teamRepository.delete(team);
	}

}
