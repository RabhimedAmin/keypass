package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.TeamService;
import com.example.model.AccessAccount;
import com.example.model.Member;
import com.example.model.Team;

@RestController("/groupes")
@RequestMapping("/groupes")
public class TeamController
{
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Team> getgroupeById(
			@PathVariable("id") final Long groupeId)
	{
		Team searchedgroupe = teamService.getGroupe(groupeId);
		return new ResponseEntity<>(searchedgroupe, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Team>> getAllgroupe()
	{
		List<Team> searchedgroupe = teamService.getAllGroupes();
		return new ResponseEntity<>(searchedgroupe, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String creategroupe(@RequestBody Team team)
	{
		teamService.createGroupe(team);
		return "redirect:/groupe/" + team.getId();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(Team team)
	{
		teamService.modifyGroupe(team);
		return "redirect:/groupe/" + team.getId();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id)
	{
		teamService.deleteGroupe(id);
		return "redirect:/groupes";
	}
	
	// @RequestMapping(value = ("/{id}/addAgent"), method = RequestMethod.POST)
	// public String affecteAgentToGroupe(
	// @PathVariable("id") Groupe groupe, @RequestBody List<Agent> agents)
	// {
	// groupeService.affectAgentTOGroupe(groupe, agents);
	//
	// return "redirect:/groupes";
	// }
	
	@RequestMapping(value = ("/{id}/accounts"), method = RequestMethod.POST)
	public ResponseEntity<?> affecteAccountToGroupe(
			@PathVariable("id") Team team, @RequestBody AccessAccount accessAccount)
	{
		teamService.ajouterAccount(team, accessAccount);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/deleteAgent", method = RequestMethod.DELETE)
	public String deleteAgentFromGroupe(@PathVariable("id") Team team,
			@RequestBody Member member)
	{
		teamService.supprimerAgent(team, member);
		return "redirect:/groupes";
	}
	
	@RequestMapping(value = ("/{id}/ajoutAgent"), method = RequestMethod.POST)
	public String ajoutAgentToGroupe(@PathVariable("id") Team team,
			@RequestBody Member member)
	{
		teamService.memberToTeam(team, member);
		
		return "redirect:/groupes";
	}
	// @RequestMapping(value = ("/"), method = RequestMethod.POST)
	// public ResponseEntity<?> affecteAccountToGroupe(
	// @PathVariable("id") Groupe groupe,Account account
	// )
	// {
	// groupeService.ajouterAccount(groupe, account);
	//
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
}