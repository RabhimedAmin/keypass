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

import com.example.Service.GroupeService;
import com.example.model.Account;
import com.example.model.Agent;
import com.example.model.Groupe;

@RestController("/groupes")
@RequestMapping("/groupes")
public class GroupeController
{
	@Autowired
	private GroupeService groupeService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Groupe> getgroupeById(
			@PathVariable("id") final Long groupeId)
	{
		Groupe searchedgroupe = groupeService.getGroupe(groupeId);
		return new ResponseEntity<>(searchedgroupe, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Groupe>> getAllgroupe()
	{
		List<Groupe> searchedgroupe = groupeService.getAllGroupes();
		return new ResponseEntity<>(searchedgroupe, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String creategroupe(@RequestBody Groupe groupe)
	{
		groupeService.createGroupe(groupe);
		return "redirect:/groupe/" + groupe.getId();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(Groupe groupe)
	{
		groupeService.modifyGroupe(groupe);
		return "redirect:/groupe/" + groupe.getId();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id)
	{
		groupeService.deleteGroupe(id);
		return "redirect:/groupes";
	}
	
	@RequestMapping(value = ("/{id}/addAgent"), method = RequestMethod.POST)
	public String affecteAgentToGroupe(
			@PathVariable("id") Groupe groupe, @RequestBody List<Agent> agents)
	{
		groupeService.affectAgentTOGroupe(groupe, agents);
		
		return "redirect:/groupes";
	}
	
	@RequestMapping(value = ("/{id}/accounts"), method = RequestMethod.POST)
	public ResponseEntity<?> affecteAccountToGroupe(
			@PathVariable("id") Groupe groupe, @RequestBody Account account)
	{
		groupeService.ajouterAccount(groupe, account);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/deleteAgent", method = RequestMethod.DELETE)
	public String deleteAgentFromGroupe(@PathVariable ("id") Groupe groupe, @RequestBody Agent agent)
	{
		groupeService.supprimerAgent(groupe, agent);
		return "redirect:/groupes";
	}
//	@RequestMapping(value = ("/"), method = RequestMethod.POST)
//	public ResponseEntity<?> affecteAccountToGroupe(
//			@PathVariable("id") Groupe groupe,Account account
//			)
//	{
//		groupeService.ajouterAccount(groupe, account);
//	
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}