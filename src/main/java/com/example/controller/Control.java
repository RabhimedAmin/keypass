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
import com.example.Service.ServerService;
import com.example.model.Agent;
import com.example.model.Server;

@RestController
public class Control {

	@Autowired
	ServerService serverService;
	
	@Autowired
	private GroupeService groupeService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/hama")
	public ResponseEntity<?> validateRequest() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//@RequestMapping(name = "/server/{id}", method = RequestMethod.GET)
	public ResponseEntity<Server> getServerById(@PathVariable("id") final Long serverId) {
		Server searchedServer = serverService.getServer(serverId);
		return new ResponseEntity<>(searchedServer, HttpStatus.OK);
	}

	//@RequestMapping(name = "/servers", method = RequestMethod.GET)
	public ResponseEntity<List<Server>> getAllServer() {
		List<Server> searchedServers = serverService.getAllServer();
		return new ResponseEntity<>(searchedServers, HttpStatus.OK);
	}

	//@RequestMapping(name = "/server/{id}/affecte", method = RequestMethod.PUT)
	public ResponseEntity<?> affecteServerToAccounts(@PathVariable("id") Long serverId,
			@RequestBody List<Long> accountsIds) {
		//groupeService.affectAgentTOGroupe(groupe, agent);
		boolean affected = serverService.affecteServerToAccounts(serverId, accountsIds);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//@RequestMapping(value = "server", method = RequestMethod.POST)
	public String createServer(Server server) {
		serverService.createServer(server);
		return "redirect:/server/" + server.getId();
	}
}


































