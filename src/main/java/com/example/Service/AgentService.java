package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Agent;

public interface AgentService {

	public Agent createAgent(Agent agent);
	
	void deleteAgent(long id);

	Agent modifyAgent(Agent agent);

	List<Agent> getAllAgents();

	Agent getAgent(long id);
}
