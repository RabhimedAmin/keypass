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

import com.example.Service.DemandeService;

import com.example.model.Demande;

@RestController("/Demandes")
@RequestMapping("/Demandes")
public class DemandeController {
	@Autowired
	private DemandeService demandeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Demande> getdemandeById(@PathVariable("id") final Long demandeId) {
		Demande searcheddemande = demandeService.getDemande(demandeId);
		return new ResponseEntity<>(searcheddemande, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Demande>> getAlldemandes() {
		List<Demande> searcheddemande = demandeService.getAllDemandes();
		return new ResponseEntity<>(searcheddemande, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public String creatdemande(Demande demande) {
		demandeService.createdemande(demande);
		return "redirect:/Demandes/" + demande.getId();
	}

	@RequestMapping(value = "/demande/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody Demande demande) {
		demandeService.modifydemande(demande);
		return "redirect:/Demandes/" + demande.getId();

	}

	@RequestMapping(value = "/demande/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		demandeService.deleteDemande(id);
		return "redirect:/Demandes";
	}
}