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
	private boolean admin = false;

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @param cin
	 * @param agentname
	 * @param function
	 * @param admin
	 */
	public Agent(long cin, String agentname, String function, boolean admin) {
		super();
		this.cin = cin;
		Agentname = agentname;
		this.function = function;
		this.admin = admin;
	}

	/**
	 * 
	 */
	public Agent() {
		super();
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
	 * @param cin
	 *            the cin to set
	 */
	public void setCin(long cin) {
		this.cin = cin;
	}

}
