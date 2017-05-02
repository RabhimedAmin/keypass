package com.example.model;

import javax.persistence.*;

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
	
}
