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

import com.example.Service.PartageRessourceService;

import com.example.model.PartageRessource;

@RestController("/PartageRessources")
@RequestMapping("/PartageRessources")
public class PartageRessourceController {
	@Autowired
	private PartageRessourceService partageRessourceService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PartageRessource> getpartageRessourceById(@PathVariable("id") final Long partageRessourceId) {
		PartageRessource searchedpartageRessource = partageRessourceService.getPartageRessource(partageRessourceId);
		return new ResponseEntity<>(searchedpartageRessource, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<PartageRessource>> getAllpartageRessources() {
		List<PartageRessource> searchedpartageRessource = partageRessourceService.getAllPartageRessources();
		return new ResponseEntity<>(searchedpartageRessource, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public String creatpartageRessource(PartageRessource partageRessource) {
		partageRessourceService.createPartageRessource(partageRessource);
		return "redirect:/partageRessources/" + partageRessource.getId();
	}

	@RequestMapping(value = "/partageRessource/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody PartageRessource partageRessource) {
		partageRessourceService.modifyPartageRessource(partageRessource);
		return "redirect:/partageRessources/" + partageRessource.getId();

	}

	@RequestMapping(value = "/partageRessource/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		partageRessourceService.deletePartageRessource(id);
		return "redirect:/partageRessources";
	}
}