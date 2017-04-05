package com.example.Service;

import java.util.List;

import com.example.model.Account;
import com.example.model.Agent;
import com.example.model.Groupe;

public interface GroupeService {
	public Groupe createGroupe(Groupe groupe);

	public Groupe modifyGroupe(Groupe groupe);

	

	void deleteGroupe(long id);

	public Groupe getGroupe(long id);

	public List<Groupe> getAllGroupes();

	boolean affecterAgentToGroupe(Groupe groupe, Agent agent);
}
