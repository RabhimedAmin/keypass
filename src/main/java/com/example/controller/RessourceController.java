package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.AccountService;
import com.example.Service.RessourceService;
import com.example.business.AccountDto;
import com.example.business.ResourceDto;
import com.example.model.Account;
import com.example.model.Ressource;

@RestController("/ressources")
@RequestMapping("/ressources")
public class RessourceController
{
	@Autowired
	private RessourceService ressourceService;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ressource> getRessourceById(
			@PathVariable("id") final Long ressourceId)
	{
		Ressource searchedressource = ressourceService
				.getRessource(ressourceId);
		return new ResponseEntity<>(searchedressource, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Ressource>> getAllressources()
	{
		List<Ressource> searchedressource = ressourceService.getAllRessources();
		return new ResponseEntity<>(searchedressource, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String creatressource(@RequestBody ResourceDto ressourceDto)
	{
		Ressource ressource = ressourceService
				.createRessource(ressourceDto.toModel());
		return "redirect:/ressource/" + ressource.getId();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") Ressource model,
			@RequestBody ResourceDto ressource)
	{
		Assert.notNull(model, "Ressource introuvable");
		model.setDescription(ressource.getDescription());
		model.setExpirationDate(ressource.getExpirationDate());
		ressourceService.modifyRessource(model);
		return "redirect:/ressource/" + model.getId();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id)
	{
		ressourceService.deleteRessource(id);
		return "redirect:/ressources";
	}
	
	@RequestMapping(value = "/{id}/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAllAccountsByRessoourceId(
			@PathVariable("id") Ressource r)
	{
		System.err.println(r.getAccountsRessource());
		List<Account> searchedAccount = accountService.getAllAccounts();
		return new ResponseEntity<>(searchedAccount, HttpStatus.OK);
	}
	
	// @RequestMapping(value = "/{id}/accounts", method = RequestMethod.POST)
	// public String creatAccount(@PathVariable("id") Ressource resource,
	// Account account) {
	// Account myAccount = accountService.createAccount(account);
	// Assert.notNull(resource, " Creation account impossible.Resource ne peut
	// pas être null");
	// ressourceService.addAccountToRessource(resource, myAccount);
	// return "redirect:/ressources/" + resource.getId()+"/accounts";
	// }
	
	@RequestMapping(value = "/{idRessource}/accounts", method = RequestMethod.POST)
	public String creatAccount(@PathVariable("idRessource") Ressource resource,
			@RequestBody Account account)
	{
		Assert.notNull(resource,
				" Creation account impossible.Resource ne peut pas être null");
		ressourceService.addAccountToRessource(resource, account);
		return "redirect:/ressources/" + resource.getId() + "/accounts";
		
	}
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountById(
			@PathVariable("id") Ressource ressource, Long Id)
	{
		Account searchedAccount = accountService.getAccount(Id);
		return new ResponseEntity<>(searchedAccount, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") Account model,
			@RequestBody AccountDto account)
	{
		model.setLogin(account.getLogin());
		
		model.setDescription(account.getDescription());
		model.setPassword(account.getNewPassword());
		accountService.modifyAccount(model);
		return "redirect:/account/" + model.getId();
		
	}
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
	public String deleteAccountFromRessource(Long id)
	{
		accountService.deleteAccount(id);
		return "redirect:/accounts";
	}
	
}
