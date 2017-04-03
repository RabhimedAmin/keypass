package com.example.model;

import javax.persistence.*;

@Entity
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cin;
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

	public Agent(long cin, String agentname, String function) {
		super();
		this.cin = cin;
		Agentname = agentname;
		this.function = function;
	}

	public long getCin() {
		return cin;
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

	/**
	 * @param cin the cin to set
	 */
	public void setCin(long cin) {
		this.cin = cin;
	}

	

}
