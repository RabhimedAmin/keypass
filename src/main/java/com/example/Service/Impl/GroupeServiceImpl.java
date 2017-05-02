package com.example.Service.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.GroupeService;
import com.example.model.Account;
import com.example.model.Agent;
import com.example.model.Groupe;
import com.example.repository.AgentRepository;
import com.example.repository.GroupeRepository;

@Service("groupeService")
public class GroupeServiceImpl implements GroupeService
{
	@Autowired
	private GroupeRepository groupeRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public Groupe createGroupe(Groupe groupe)
	{
		// TODO Auto-generated method stub
		return groupeRepository.save(groupe);
	}
	
	@Override
	public Groupe modifyGroupe(Groupe groupe)
	{
		// TODO Auto-generated method stub
		return groupeRepository.save(groupe);
	}
	
	@Override
	public boolean agentAffectee(Groupe groupe, Agent agent)
	{
		
		if (groupe.getAgentList().contains(agent)) { return true; }
		return false;
	}
	
	@Override
	public boolean accountAffectee(Groupe groupe, Account account)
	{
		if (groupe.getAccounts().contains(account)) { return true; }
		return false;
	}
	
	@Override
	public boolean affectAgentTOGroupe(Groupe groupe, List<Agent> agents)
	{
		boolean affected = false;
		if (agents != null && !agents.isEmpty())
			for (Agent agent : agents)
			{
				if(agentAffectee(groupe, agent)){
					continue;
				}
				groupe.getAgentList().add(agent);
				groupeRepository.save(groupe);
				agentRepository.save(agent);
				affected = true;
			}
		return affected;
	}
	
	public void supprimerAgent(Groupe groupe, Agent agent)
	{
		if (agentAffectee(groupe, agent))
			groupe.getAgentList().remove(agent);
	}
	
	@Override
	public Groupe getGroupe(long id)
	{
		// TODO Auto-generated method stub
		return groupeRepository.findOne(id);
	}
	
	@Override
	public List<Groupe> getAllGroupes()
	{
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}
	
	@Override
	public void deleteGroupe(long id)
	{
		// TODO Auto-generated method stub
		groupeRepository.delete(id);
	}
	
	@Override
	public Set<Account> ajouterAccount(Groupe groupe,Account account){
	if(!accountAffectee(groupe,account))
	{groupe.getAccounts().add(account);}
	return groupe.getAccounts();
		
	}
}
