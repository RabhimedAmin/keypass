package com.example.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Groupe
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "groupeId")
	@JsonIgnore
	private List<Agent> agentList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Groupe_account", 
		joinColumns = @JoinColumn(name = "groupe_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id")
	)
	@JsonIgnore
	private Set<Account> accounts;
	
	private String libelle;
	
	private String description;
	
	/**
	 * 
	 */
	public Groupe()
	{
		super();
	}
	
	/**
	 * @return the groupeId
	 */
	public Long getId()
	{
		return id;
	}
	
	/**
	 * @return the agentList
	 */
	@JsonIgnore
	public List<Agent> getAgentList()
	{
		return agentList;
	}
	
	
	public Set<Account> getAccounts()
	{
		return accounts;
	}
	
	/**
	 * @param agentList
	 *            the agentList to set
	 */
	@JsonIgnore
	public void setAgentList(List<Agent> agentList)
	{
		this.agentList = agentList;
	}
	
	
	
	/**
	 * @return the libelle
	 */
	public String getLibelle()
	{
		return libelle;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result
				+ ((agentList == null) ? 0 : agentList.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe other = (Groupe) obj;
		if (accounts == null)
		{
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (agentList == null)
		{
			if (other.agentList != null)
				return false;
		} else if (!agentList.equals(other.agentList))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null)
		{
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Groupe [id=" + id + ", agentList=" + agentList + ", accounts="
				+ accounts + ", libelle=" + libelle + ", description="
				+ description + "]";
	}
}
