package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.model.Agent;
import com.example.model.Groupe;

public interface GroupeService
{
	public Groupe createGroupe(Groupe groupe);
	
	public Groupe modifyGroupe(Groupe groupe);
	
	void deleteGroupe(long id);
	
	public Groupe getGroupe(long id);
	
	public List<Groupe> getAllGroupes();
	
	Agent affectAgentTOGroupe(Groupe groupe, Agent agent);
	
	boolean agentAffectee(Groupe groupe, Agent agent);
	
	public void supprimerAgent(Groupe groupe,Agent agent); 
}
