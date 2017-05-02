package com.example.model;

import java.util.Set;

import javax.persistence.*;

import org.springframework.util.Assert;

import com.example.business.AccountDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@ManyToMany(mappedBy = "accounts")
	@JsonIgnore
	private Set<Groupe> groupes;
	
	private AccountType type;
	
	public enum AccountType
	{
		GUEST, ROOT, USER
	};
	
	public Set<Groupe> getGroupes()
	{
		return groupes;
	}
	@JsonIgnore
	public void setGroupe(Set<Groupe> groupes)
	{
		this.groupes = groupes;
	}
	
	/**
	 * 
	 */
	public Account()
	{
		super();
	}
	
	public Long getId()
	{
		return id;
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public AccountType getType()
	{
		return type;
	}
	
	public void setType(AccountType type)
	{
		this.type = type;
	}
	
	private boolean verifPassword(String oldPassword )
	{
		Assert.notNull(this.password, "password ne peut pas être null");
		Assert.notNull(oldPassword, "password ne peut pas être null");
		return this.getPassword().equals(oldPassword);	
     }
	public void updatePassword(AccountDto accountDto)
	{
		Assert.notNull(accountDto, "compte ne peut pas être null");
		Assert.isTrue(verifPassword(accountDto.getOldPassword()), "Erruer lors de la vérification du mot de passe");
		this.setPassword(accountDto.getNewPassword());
	}
}
