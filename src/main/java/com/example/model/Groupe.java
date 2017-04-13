package com.example.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Groupe
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "groupeId")
	private List<Agent> agentList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Groupe_account", joinColumns = @JoinColumn(name = "groupe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
	private Set<Account> accounts;
	
	public Set<Account> getAccounts()
	{
		return accounts;
	}
	
	/**
	 * 
	 */
	public Groupe()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the groupeId
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * @return the agentList
	 */
	public List<Agent> getAgentList()
	{
		return agentList;
	}
	
	/**
	 * @param agentList
	 *            the agentList to set
	 */
	public void setAgentList(List<Agent> agentList)
	{
		this.agentList = agentList;
	}
	
	public void setAccounts(Set<Account> accounts)
	{
		this.accounts = accounts;
	}
}
