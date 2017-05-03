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
	
	@ManyToMany(mappedBy = "access")
	@JsonIgnore
	private Set<Agent> agents;
	
	private String description;
	
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
	
	/**
	 * @return the agents
	 */
	public Set<Agent> getAgents()
	{
		return agents;
	}
	

	/**
	 * @param agents the agents to set
	 */
	
	
	public Set<Groupe> getGroupes()
	{
		return groupes;
	}
	
	
	/**
	 * 
	 */
	
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	
	private boolean verifPassword(String oldPassword)
	{
		Assert.notNull(this.password, "password ne peut pas être null");
		Assert.notNull(oldPassword, "password ne peut pas être null");
		return this.getPassword().equals(oldPassword);
	}
	
	public void updatePassword(AccountDto accountDto)
	{
		Assert.notNull(accountDto, "compte ne peut pas être null");
		Assert.isTrue(verifPassword(accountDto.getOldPassword()),
				"Erruer lors de la vérification du mot de passe");
		this.setPassword(accountDto.getNewPassword());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Account [id=" + id + ", login=" + login + ", password="
				+ password + ", groupes=" + groupes + ", agents=" + agents
				+ ", description=" + description + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agents == null) ? 0 : agents.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((groupes == null) ? 0 : groupes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
		Account other = (Account) obj;
		if (agents == null)
		{
			if (other.agents != null)
				return false;
		} else if (!agents.equals(other.agents))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (groupes == null)
		{
			if (other.groupes != null)
				return false;
		} else if (!groupes.equals(other.groupes))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null)
		{
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null)
		{
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	
}
