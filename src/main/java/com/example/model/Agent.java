package com.example.model;

import javax.persistence.*;

@Entity
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String Agentname;

	@Column(name = "Function")
	private String function;

	/**
	 * 
	 */
	public Agent() {
		super();
	}

	public Agent(Long id, String agentname, String function) {
		super();
		this.id = id;
		Agentname = agentname;
		this.function = function;
	}

	public long getId() {
		return id;
	}

	public String getAgentname() {
		return Agentname;
	}

	public void setAgentname(String agentname) {
		Agentname = agentname;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	
}
