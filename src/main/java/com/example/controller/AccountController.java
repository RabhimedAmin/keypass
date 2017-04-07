package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.AccountService;
import com.example.model.Account;

@RestController("/accounts")
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountById(@PathVariable("id") final Long accountId) {
		Account searchedAccount = accountService.getAccount(accountId);
		return new ResponseEntity<>(searchedAccount, HttpStatus.OK);

	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> searchedAccount = accountService.getAllAccounts();
		return new ResponseEntity<>(searchedAccount, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST)
	public String creatAccount(Account account) {
		accountService.createAccount(account);
		return "redirect:/account/" + account.getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody Account account) {
		accountService.modifyAccount(account);
		return "redirect:/account/" + account.getId();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		accountService.deleteAccount(id);
		return "redirect:/accounts";
	}
}
