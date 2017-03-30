package com.bellinfo.cricket.dao;

import java.util.List;

import com.bellinfo.cricket.model.Player;
import com.bellinfo.cricket.model.Team;

public interface TeamRepository {
	
	public void addTeam(Team team);
	public void updateTeam(Team team);
	public Team getTeam(int id);
	public void deleteTeam(int id);
	
	public List<Team> getTeams();
	public void updateTeam(Player player);
	//public Player getPlayer(Integer id);
	public void addPlayer(Player player);
	public List<Player> getPlayers();
	//public void updatePlayer(Player player);
	public Player getPlayer(Integer id);
	public void updatePlayer(Player player);
	public void deletePlayer(Integer id);
	
	

}
