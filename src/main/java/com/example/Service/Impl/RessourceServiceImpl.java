package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Service.RessourceService;
import com.example.Service.ServerService;
import com.example.model.Account;
import com.example.model.Ressource;
import com.example.model.Server;
import com.example.repository.AccountRepository;
import com.example.repository.RessourceRepository;

@Service
public class RessourceServiceImpl implements RessourceService
{
	@Autowired
	private RessourceRepository ressourceRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	public void setRessourceRepository(RessourceRepository ressourceRepository)
	{
		this.ressourceRepository = ressourceRepository;
	}
	
	@Override
	public Ressource createRessource(Ressource ressource)
	{
		// TODO Auto-generated method stub
		return ressourceRepository.save(ressource);
	}
	
	@Override
	public List<Ressource> getAllRessources()
	{
		// TODO Auto-generated method stub
		return ressourceRepository.findAll();
	}
	
	@Override
	public Ressource modifyRessource(Ressource ressource)
	{
		return ressourceRepository.save(ressource);
	}
	
	@Override
	public Ressource getRessource(long id)
	{
		// TODO Auto-generated method stub
		return ressourceRepository.findOne(id);
	}
	
	@Override
	public void deleteRessource(long id)
	{
		// TODO Auto-generated method stub
		ressourceRepository.delete(id);
	}
	
	//@Override
//	public boolean testAccount(Ressource ressource, Account account)
//	{
//		if (ressource.getAccountsRessource().contains(account))
//			return true;
//		return false;
//	}
	
	@Override
	public List<Account> addAccountToRessource(Ressource ressource,
			Account account)
	{
		accountRepository.save(account);
		ressource.getAccountsRessource().add(account);
		ressourceRepository.save(ressource);
		return ressource.getAccountsRessource();
		
	}
}
