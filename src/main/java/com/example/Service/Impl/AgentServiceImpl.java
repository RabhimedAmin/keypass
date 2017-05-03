package com.example.Service.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.AgentService;
import com.example.model.Account;
import com.example.model.Agent;
import com.example.model.Groupe;
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
	@Override
	public boolean accountAffectee(Agent agent, Account account)
	{
		if (agent.getAccess().contains(account)) { return true; }
		return false;
	}
	@Override
	public Set<Account> ajouterAccount(Agent agent,Account account){
	if(!accountAffectee(agent,account))
	{agent.getAccess().add(account);}
	return agent.getAccess();
    }
}
