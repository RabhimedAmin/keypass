package com.example.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agent
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name")
	private String agentName;
	
	@Column(name = "Function")
	private String function;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Agent_account", 
		joinColumns = @JoinColumn(name = "Agent_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id")
	)
	@JsonIgnore
	private Set<Account> access;

	/**
	 * 
	 */
	public Agent()
	{
		super();
	}
	
	public Long getId()
	{
		return id;
	}
	
	public String getAgentName()
	{
		return agentName;
	}
	
	public void setAgentName(String agentname)
	{
		agentName = agentname;
	}
	
	public String getFunction()
	{
		return function;
	}
	
	public void setFunction(String function)
	{
		this.function = function;
	}

	/**
	 * @return the accounts
	 */
	public Set<Account> getAccess()
	{
		return access;
	}

	/**
	 * @param accounts the accounts to set
	 */
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Agent [id=" + id + ", agentName=" + agentName + ", function="
				+ function + ", accounts=" + access + "]";
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
				+ ((access == null) ? 0 : access.hashCode());
		result = prime * result
				+ ((agentName == null) ? 0 : agentName.hashCode());
		result = prime * result
				+ ((function == null) ? 0 : function.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Agent other = (Agent) obj;
		if (access == null)
		{
			if (other.access != null)
				return false;
		} else if (!access.equals(other.access))
			return false;
		if (agentName == null)
		{
			if (other.agentName != null)
				return false;
		} else if (!agentName.equals(other.agentName))
			return false;
		if (function == null)
		{
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
