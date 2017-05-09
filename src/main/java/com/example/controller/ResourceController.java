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

import com.example.Service.AccessAccountService;
import com.example.Service.ResourceService;
import com.example.business.AccountDto;
import com.example.business.ResourceDto;
import com.example.model.AccessAccount;
import com.example.model.Resource;

@RestController("/ressources")
@RequestMapping("/ressources")
public class ResourceController
{
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private AccessAccountService accessAccountService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Resource> getRessourceById(
			@PathVariable("id") final Long ressourceId)
	{
		Resource searchedressource = resourceService
				.getRessource(ressourceId);
		return new ResponseEntity<>(searchedressource, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Resource>> getAllressources()
	{
		List<Resource> searchedressource = resourceService.getAllRessources();
		return new ResponseEntity<>(searchedressource, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String creatressource(@RequestBody ResourceDto ressourceDto)
	{
		Resource resource = resourceService
				.createRessource(ressourceDto.toModel());
		return "redirect:/ressource/" + resource.getId();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") Resource model,
			@RequestBody ResourceDto ressource)
	{
		Assert.notNull(model, "Ressource introuvable");
		model.setDescription(ressource.getDescription());
		model.setExpirationDate(ressource.getExpirationDate());
		resourceService.modifyRessource(model);
		return "redirect:/ressource/" + model.getId();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id)
	{
		resourceService.deleteRessource(id);
		return "redirect:/ressources";
	}
	
	@RequestMapping(value = "/{id}/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<AccessAccount>> getAllAccountsByRessoourceId(
			@PathVariable("id") Resource r)
	{
		System.err.println(r.getAccountsRessource());
		List<AccessAccount> searchedAccount = accessAccountService.getAllAccounts();
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
	public String creatAccount(@PathVariable("idRessource") Resource resource,
			@RequestBody AccessAccount accessAccount)
	{
		Assert.notNull(resource,
				" Creation account impossible.Resource ne peut pas être null");
		resourceService.addAccountToRessource(resource, accessAccount);
		return "redirect:/ressources/" + resource.getId() + "/accounts";
		
	}
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccessAccount> getAccountById(
			@PathVariable("id") Resource resource, Long Id)
	{
		AccessAccount searchedAccount = accessAccountService.getAccount(Id);
		return new ResponseEntity<>(searchedAccount, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") AccessAccount model,
			@RequestBody AccountDto account)
	{
		model.setLogin(account.getLogin());
		
		model.setDescription(account.getDescription());
		model.setPassword(account.getNewPassword());
		accessAccountService.modifyAccount(model);
		return "redirect:/account/" + model.getId();
		
	}
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
	public String deleteAccountFromRessource(Long id)
	{
		accessAccountService.deleteAccount(id);
		return "redirect:/accounts";
	}
	
}
