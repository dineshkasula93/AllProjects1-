package com.bellinfo.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bellinfo.cricket.dao.TeamRepository;
import com.bellinfo.cricket.model.Player;
import com.bellinfo.cricket.model.Team;

@Service
@Transactional
public  class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamRepository repository;
	
	public void addTeam(Team team) {
		repository.addTeam(team);
	}

	public void updateTeam(Team team) {
		repository.updateTeam(team);
		
	}

	public Team getTeam(int id) {
		// TODO Auto-generated method stub
		return  repository.getTeam(id);
		
	}

	public void deleteTeam(int id) {
		repository.deleteTeam(id);
		
	}

	public List<Team> getTeams() {
		return repository.getTeams();
	}

	@Override
	public void updateTeam(Player player) {
		// TODO Auto-generated method stub
		repository.updateTeam(player);
	}

//	@Override
//	public Player getPlayer(Integer id) {
//		// TODO Auto-generated method stub
//		return repository.getPlayer(id);
//	}

	
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		repository.addPlayer(player);
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return repository.getPlayers();
	}

	@Override
	public Player getPlayer(Integer id) {
		// TODO Auto-generated method stub
		return repository.getPlayer(id);
	}

	@Override
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub
		repository.updatePlayer(player);
	}

	@Override
	public void deletePlayer(Integer id) {
		// TODO Auto-generated method stub
		repository.deletePlayer(id);
	}

}
