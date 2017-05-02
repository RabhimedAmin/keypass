package com.example.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.DemandeService;
import com.example.business.DemandeDto;
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

	@RequestMapping( method = RequestMethod.POST, consumes=APPLICATION_JSON_VALUE)
	public String creatdemande(@ RequestBody DemandeDto demande) {
		
		
		Demande model = demandeService.createNewDemande(demande.getId_Requester(), 
				demande.getId_Approver(), demande.getId_resource(), demande.toModel());
		return "redirect:/Demandes/" + model.getId();
	}

	@RequestMapping(value = "/demande/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody Demande demande) {
		demandeService.modifydemande(demande);
		return "redirect:/Demandes/" + demande.getId();

	}

	@RequestMapping(value = "/demande/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		demandeService.deleteDemande(id);
		return "redirect:/Demandes";
	}
}