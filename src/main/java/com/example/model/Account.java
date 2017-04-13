package com.example.model;

import java.util.Set;

import javax.persistence.*;

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
	private Set<Groupe> groupes;
	
	private AccountType type;
	
	private enum AccountType
	{
		GUEST, ROOT, USER
	};
	
	public Set<Groupe> getGroupes()
	{
		return groupes;
	}
	
	public void setBooks(Set<Groupe> groupes)
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
	
	public long getId()
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
	
	public void setServer(Server myServer)
	{
		// this.server
		
	}
	
	public AccountType getType()
	{
		return type;
	}
	
	public void setType(AccountType type)
	{
		this.type = type;
	}
}
