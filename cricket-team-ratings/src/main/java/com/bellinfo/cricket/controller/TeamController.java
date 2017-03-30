package com.bellinfo.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bellinfo.cricket.model.Player;
import com.bellinfo.cricket.model.Team;
import com.bellinfo.cricket.service.TeamService;


@Controller
@RequestMapping(value="/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTeamPage(){
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Team team){
		ModelAndView modelAndView = new ModelAndView("home");
		teamService.addTeam(team);
		String str = "Team was successfully added";
		modelAndView.addObject("message", str);
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfTeams(){
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams",teams);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		
		Team team = teamService.getTeam(id);
		modelAndView.addObject("team", team);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editingTeam(@ModelAttribute Team team, @PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("home");
		
		teamService.updateTeam(team);
		String message = "Team was successfully Edited";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("home");
		
		teamService.deleteTeam(id);
		String message = "Team was successfully deleted";
		modelAndView.addObject("message", message);
		return modelAndView;
		
	}
//	@RequestMapping(value="/addplayer/{id}", method=RequestMethod.GET)
//	public ModelAndView addplayer(@PathVariable Integer id){
//		ModelAndView modelAndView = new ModelAndView("add-player-form");
//		Player player = teamService.getPlayer(id);
//		modelAndView.addObject("player", player);
//		return modelAndView;
//	}
	
	@RequestMapping(value="/addplayer/{id}", method=RequestMethod.GET)
	public ModelAndView addPlayerPage(@PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("add-player-form");
		modelAndView.addObject("player", new Player());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addplayer", method=RequestMethod.POST)
	public ModelAndView addingplayer(@ModelAttribute Player player){
		ModelAndView modelAndView = new ModelAndView("playerhome");
		
		teamService.addPlayer(player);
		String message = "Player was successfully Added";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="/playerlist")
	public ModelAndView listOfPlayers(){
		ModelAndView modelAndView = new ModelAndView("list-of-players");
		List<Player> players = teamService.getPlayers();
		modelAndView.addObject("players",players);
		return modelAndView;
	}
	
  @RequestMapping(value="/editplayer/{id}", method=RequestMethod.GET)
	public ModelAndView editPlayerPage(Player player, @PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("edit-player-from");
		player = teamService.getPlayer(id);
		modelAndView.addObject("player", player);
		return modelAndView;
	}
	
	@RequestMapping(value="/editplayer/{id}", method=RequestMethod.POST)
	public ModelAndView editingPlayer(@ModelAttribute Player player ,@PathVariable Integer id){
		ModelAndView modelAndView = new ModelAndView("playerhome");
		
		teamService.updatePlayer(player);
		String message = "Player was successfully Edited";
		modelAndView.addObject("message", message);
	return modelAndView;
	}
	

	@RequestMapping(value="/deleteplayer/{id}", method=RequestMethod.GET)
    public ModelAndView deletePlayer(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("playerhome");
		
		teamService.deletePlayer(id);
		String message = "player was successfully deleted";
		modelAndView.addObject("message", message);
		return modelAndView;
		
	}
}
