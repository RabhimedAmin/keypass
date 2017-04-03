package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.AgentService;

import com.example.model.Agent;

import com.example.repository.AgentRepository;

@Service("agentService")
public class AgentServiceImpl implements AgentService {

	@Autowired
	public void setAgentRepository(AgentRepository agentRepository) {
		this.agentRepository = agentRepository;
	}

	@Autowired
	AgentRepository agentRepository;

	@Override
	public void deleteAgent(long id) {
		// TODO Auto-generated method stub
		agentRepository.delete(id);
	}

	@Override
	public Agent getAgent(long id) {
		// TODO Auto-generated method stub
		return agentRepository.findOne(id);
	}

	@Override
	public List<Agent> getAllAgents() {
		// TODO Auto-generated method stub
		return agentRepository.findAll();
	}

	@Override
	public Agent modifyAgent(Agent agent) {
		// TODO Auto-generated method stub
		return agentRepository.save(agent);
	}

	@Override
	public Agent createAgent(Agent agent) {
		// TODO Auto-generated method stub
		return agentRepository.save(agent);
	}

}
