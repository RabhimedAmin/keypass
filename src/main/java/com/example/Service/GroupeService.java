package com.example.Service;

import java.util.List;
import java.util.Set;

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
	
	boolean affectAgentTOGroupe(Groupe groupe, List<Agent> agents);
	
	boolean agentAffectee(Groupe groupe, Agent agent);
	
	public void supprimerAgent(Groupe groupe,Agent agent);

	boolean accountAffectee(Groupe groupe, Account account);

	Set<Account> ajouterAccount(Groupe groupe, Account account); 
}
