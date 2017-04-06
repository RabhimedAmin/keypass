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
import com.example.model.Groupe;

@RestController("/")
public class GroupeController {
	@Autowired
	private GroupeService groupeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Groupe> getgroupeById(@PathVariable("id") final Long groupeId) {
		Groupe searchedgroupe = groupeService.getGroupe(groupeId);
		return new ResponseEntity<>(searchedgroupe, HttpStatus.OK);
	}

	@RequestMapping(value = "/groupes", method = RequestMethod.GET)
	public ResponseEntity<List<Groupe>> getAllgroupe() {
		List<Groupe> searchedgroupe = groupeService.getAllGroupes();
		return new ResponseEntity<>(searchedgroupe, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String creategroupe(Groupe groupe) {
		groupeService.createGroupe(groupe);
		return "redirect:/product/" + groupe.getId();
	}

	@RequestMapping(value = "/groupes/{id}", method = RequestMethod.PUT)
	public String update(Groupe groupe) {
		groupeService.modifyGroupe(groupe);
		return "redirect:/groupe/" + groupe.getId();

	}

	@RequestMapping(value = "/groupea/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		groupeService.deleteGroupe(id);
		return "redirect:/groupes";
	}
	
}
