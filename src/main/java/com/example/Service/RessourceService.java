package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.model.Ressource;
public interface RessourceService {
	public Ressource createRessource(Ressource ressource);

	public List<Ressource> getAllRessources();

	public Ressource modifyRessource(Ressource ressource);

	Ressource getRessource(long id);

	void deleteRessource(long id);

	//boolean testAccount(Ressource ressource, Account account);

	List<Account> addAccountToRessource(Ressource ressource, Account account);
}
