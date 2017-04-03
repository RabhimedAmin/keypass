package com.example.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.Service.AccountService;
import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account modifyAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public Account getAccount(long id) {
		// TODO Auto-generated method stub
		return accountRepository.findOne(id);
	}

	@Override
	
	public void deleteAccount(long id) {
		// TODO Auto-generated method stub
		accountRepository.delete(id);
	}

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
}