package com.example.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Groupe
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "groupeId")
	private List<Account> accountList;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "groupeId")
	private List<Agent> agentList;
	
	/**
	 * 
	 */
	public Groupe()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the accountList
	 */
	public List<Account> getAccountList()
	{
		return accountList;
	}
	
	/**
	 * @return the groupeId
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * @param groupeId
	 * @param accountList
	 * @param agentList
	 */
	public Groupe(long groupeId, List<Account> accountList,
			List<Agent> agentList)
	{
		super();
		this.id = id;
		this.accountList = accountList;
		this.agentList = agentList;
	}
	
	/**
	 * @param accountList
	 *            the accountList to set
	 */
	public void setAccountList(List<Account> accountList)
	{
		this.accountList = accountList;
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
}
