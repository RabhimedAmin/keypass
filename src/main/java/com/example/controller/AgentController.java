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

import com.example.Service.AgentService;
import com.example.model.Agent;

@RestController("/agents")
@RequestMapping("/agents")
public class AgentController {
	@Autowired
	private AgentService agentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agent> getAgentById(@PathVariable("id") final Long agentId) {
		Agent searchedAgent = agentService.getAgent(agentId);
		return new ResponseEntity<>(searchedAgent, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Agent>> getAllAgent() {
		List<Agent> searchedAgent = agentService.getAllAgents();
		return new ResponseEntity<>(searchedAgent, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public String createAgent(Agent agent) {
		agentService.createAgent(agent);
		return "redirect:/agent/" + agent.getId();
	}

	@RequestMapping(value = "/agent/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody Agent agent) {
		agentService.modifyAgent(agent);
		return "redirect:/agent/" + agent.getId();

	}

	@RequestMapping(value="/agent/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		agentService.deleteAgent(id);
		return "redirect:/agents";
	}
	
}
