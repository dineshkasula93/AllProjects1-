package com.bellinfo.cricket.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bellinfo.cricket.model.Player;
import com.bellinfo.cricket.model.Team;

@Repository
public class TeamRepositoryImpl implements TeamRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public void addTeam(Team team) {
		getCurrentSession().save(team);
		
	}

	public void updateTeam(Team team) {
		getCurrentSession().merge(team);
		
	}

	public Team getTeam(int id) {
		Team team = (Team)getCurrentSession().get(Team.class, id);
		
		return team;
	}

	public void deleteTeam(int id) {
		Team team = getTeam(id);
		if(team!=null){
			getCurrentSession().delete(team);
		}
		
	}

	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from Team").list();
		
	}


	@Override
	public void updateTeam(Player player) {
		// TODO Auto-generated method stub
		getCurrentSession().save(player);
	}


//	@Override
//	public Player getPlayer(Integer id) {
//		// TODO Auto-generated method stub
//		Player player = (Player)getCurrentSession().get(Player.class, id);
//		return player;
//	}
//

	
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		getCurrentSession().save(player);
		}


	
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from Player").list();
	}


	
	public Player getPlayer(Integer id) {
		// TODO Auto-generated method stub
		Player player = (Player)getCurrentSession().get(Player.class,id);
		return player;
	}


	
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub
		getCurrentSession().merge(player);
		}


	
	public void deletePlayer(Integer id) {
		// TODO Auto-generated method stub
		Player player=getPlayer(id);
		if(player!=null){
			getCurrentSession().delete(player);
		}
	}



}
