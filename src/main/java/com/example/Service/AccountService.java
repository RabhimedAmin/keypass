package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Account;
public interface AccountService {
	public Account createAccount(Account account);

	public List<Account> getAllAccounts();

	public Account modifyAccount(Account account);

	Account getAccount(long id);

	void deleteAccount(long id);
}
