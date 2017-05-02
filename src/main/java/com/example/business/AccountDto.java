/**
 * 
 */
package com.example.business;

import java.io.Serializable;

import com.example.model.Account;
import com.example.model.Account.AccountType;

import lombok.Data;

/**
 * @author user
 *
 */
@Data
public class AccountDto implements Serializable
{
	private static final long serialVersionUID = 48052757653224864L;

	private String login;
	
	private String oldPassword;
	
	private String newPassword;
	
	private AccountType type;
	
	public Account toModel(){
		Account model = new Account();
		model.setLogin(login);
		model.setPassword(newPassword);
		model.setType(type);
		return model;
	}
}
