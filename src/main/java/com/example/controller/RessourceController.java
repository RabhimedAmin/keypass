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

import com.example.Service.RessourceService;

import com.example.model.Ressource;

@RestController("/ressources")
@RequestMapping("/ressources")
public class RessourceController {
	@Autowired
	private RessourceService ressourceService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ressource> getRessourceById(@PathVariable("id") final Long ressourceId) {
		Ressource searchedressource = ressourceService.getRessource(ressourceId);
		return new ResponseEntity<>(searchedressource, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Ressource>> getAllressources() {
		List<Ressource> searchedressource = ressourceService.getAllRessources();
		return new ResponseEntity<>(searchedressource, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public String creatressource(Ressource ressource) {
		ressourceService.createRessource(ressource);
		return "redirect:/ressource/" + ressource.getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody Ressource ressource) {
		ressourceService.modifyRessource(ressource);
		return "redirect:/ressource/" + ressource.getId();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		ressourceService.deleteRessource(id);
		return "redirect:/ressources";
	}
}
